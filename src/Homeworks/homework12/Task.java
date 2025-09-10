package Homeworks.homework12;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Фамилия, Имя, Отчество, дата_рождения(dd.MM.yyyy), номер_телефона, пол(f/m), возраст");

        String input = scanner.nextLine();

        try {
            String[] parts = input.trim().split(",");
            if (parts.length != 7) {
                throw new IllegalArgumentException("Ошибка: ожидалось 7 параметров, а введено " + parts.length);
            }


            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }

            // 1. ФИО
            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];

            // 2. Дата рождения
            String birthDate = parts[3];
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            sdf.setLenient(false);
            try {
                sdf.parse(birthDate);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Ошибка: дата рождения должна быть в формате dd.MM.yyyy");
            }

            // 3. Номер телефона
            String phoneStr = parts[4];
            if (!phoneStr.matches("\\d+")) {
                throw new IllegalArgumentException("Ошибка: телефон должен содержать только цифры");
            }
            long phoneNumber = Long.parseLong(phoneStr);

            // 4. Пол
            char gender = parts[5].toLowerCase().charAt(0);
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Ошибка: пол должен быть 'f' или 'm'");
            }

            // 5. Возраст
            int age;
            try {
                age = Integer.parseInt(parts[6]);
                if (age < 0 || age > 110) {
                    throw new IllegalArgumentException("Ошибка: возраст должен быть в пределах 0–110");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Ошибка: возраст должен быть числом");
            }


            Person person = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender, age);


            File file = new File(lastName + ".txt");
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(person.toString() + "\n");
                System.out.println("Данные  сохранены в файл: " + file.getName());
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл:");
                e.printStackTrace();
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
    }
}

