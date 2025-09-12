package Attestation.attestation01.repositories;

import Attestation.attestation01.model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {
    public static final String DEFAULT_FILE = "users.txt";

    private final Path file;

    public UsersRepositoryFileImpl() {
        this(Paths.get(DEFAULT_FILE));
    }

    public UsersRepositoryFileImpl(Path file) {
        this.file = file;
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать файл: " + file, e);
        }
    }


    private List<User> readAllUsers() {
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            List<User> users = new ArrayList<>();
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                users.add(User.fromLine(line));
            }
            return users;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + file, e);
        }
    }

    private void writeAllUsers(List<User> users) {
        List<String> lines = users.stream().map(User::toLine).collect(Collectors.toList());
        try {
            Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла: " + file, e);
        }
    }

    @Override
    public synchronized void create(User user) {
        try {
            Files.write(file, (user.toLine() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка append пользователя", e);
        }
    }

    @Override
    public synchronized User findById(String id) {
        List<User> users = readAllUsers();
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователя с заданным идентификатором не существует: " + id));
    }

    @Override
    public synchronized List<User> findAll() {
        return readAllUsers();
    }

    @Override
    public synchronized void update(User user) {
        List<User> users = readAllUsers();
        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                found = true;
                break;
            }
        }
        if (!found) {
            users.add(user);
        }
        writeAllUsers(users);
    }

    @Override
    public synchronized void deleteById(String id) {
        List<User> users = readAllUsers();
        boolean removed = users.removeIf(u -> u.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Пользователя с заданным идентификатором не существует: " + id);
        }
        writeAllUsers(users);
    }

    @Override
    public synchronized void deleteAll() {
        writeAllUsers(new ArrayList<>());
    }
}

