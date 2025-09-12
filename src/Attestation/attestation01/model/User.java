package Attestation.attestation01.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class User {

    public static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private String id;
    private LocalDateTime createdAt;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;


    public User(String id,
                LocalDateTime createdAt,
                String login,
                String password,
                String confirmPassword,
                String lastName,
                String firstName,
                String middleName,
                Integer age,
                boolean isWorker) {
        this.id = id != null ? id : UUID.randomUUID().toString();
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();

        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;

        validateAll();
    }


    public User(String login, String password, String confirmPassword,
                String lastName, String firstName, String middleName,
                Integer age, boolean isWorker) {
        this(null, null, login, password, confirmPassword, lastName, firstName, middleName, age, isWorker);
    }


    public static User fromLine(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length != 10) {
            throw new IllegalArgumentException("Неправильный формат строки пользователя: " + line);
        }
        String id = parts[0];
        LocalDateTime createdAt = LocalDateTime.parse(parts[1], DT_FORMAT);
        String login = parts[2];
        String password = parts[3];
        String confirm = parts[4];
        String last = parts[5];
        String first = parts[6];
        String middle = parts[7].isEmpty() ? null : parts[7];
        Integer age = parts[8].isEmpty() ? null : Integer.valueOf(parts[8]);
        boolean isWorker = Boolean.parseBoolean(parts[9]);

        return new User(id, createdAt, login, password, confirm, last, first, middle, age, isWorker);
    }


    public String toLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("|")
                .append(createdAt.format(DT_FORMAT)).append("|")
                .append(escape(login)).append("|")
                .append(escape(password)).append("|")
                .append(escape(confirmPassword)).append("|")
                .append(escape(lastName)).append("|")
                .append(escape(firstName)).append("|")
                .append(middleName == null ? "" : escape(middleName)).append("|")
                .append(age == null ? "" : age).append("|")
                .append(isWorker);
        return sb.toString();
    }


    private String escape(String s) {
        return s == null ? "" : s.replace("|", "_");
    }


    private void validateAll() {
        validateId();
        validateLogin();
        validatePassword();
        validateNames();
        validateAge();
    }

    private void validateId() {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id должен быть непустым");
        }

    }

    private void validateLogin() {
        if (login == null) throw new IllegalArgumentException("login не может быть null");
        if (login.length() >= 20) throw new IllegalArgumentException("login должен быть < 20 символов");
        if (!login.matches("[A-Za-z0-9_]+")) throw new IllegalArgumentException("login содержит недопустимые символы");
        if (login.matches("\\d+")) throw new IllegalArgumentException("login не может состоять только из цифр");
    }

    private void validatePassword() {
        if (password == null || confirmPassword == null)
            throw new IllegalArgumentException("password/confirmPassword не могут быть null");
        if (!password.equals(confirmPassword))
            throw new IllegalArgumentException("password и confirmPassword должны совпадать");
        if (password.length() >= 20) throw new IllegalArgumentException("password должен быть < 20 символов");
        if (!password.matches("[A-Za-z0-9_]+"))
            throw new IllegalArgumentException("password содержит недопустимые символы");

        if (password.matches("[A-Za-z_]+"))
            throw new IllegalArgumentException("password не может состоять только из букв");
    }

    private void validateNames() {
        if (lastName == null || !lastName.matches("\\p{L}+"))
            throw new IllegalArgumentException("фамилия должна содержать только буквы");
        if (firstName == null || !firstName.matches("\\p{L}+"))
            throw new IllegalArgumentException("имя должно содержать только буквы");
        if (middleName != null && !middleName.matches("\\p{L}+"))
            throw new IllegalArgumentException("отчество должно содержать только буквы или быть пустым");
    }

    private void validateAge() {
        if (age != null && age < 0) throw new IllegalArgumentException("возраст не может быть отрицательным");
    }


    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isWorker() {
        return isWorker;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" + id + "," + login + "}";
    }
}

