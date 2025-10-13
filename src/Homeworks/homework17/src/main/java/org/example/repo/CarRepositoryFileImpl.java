package org.example.repo;

import org.example.Car;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarRepositoryFileImpl implements CarRepository {
    public static final String DEFAULT_FILE = "cars.txt";
    private final Path file;

    public CarRepositoryFileImpl() {
        this(Paths.get(DEFAULT_FILE));
    }

    public CarRepositoryFileImpl(Path file) {
        this.file = file;
        try {
            if (!Files.exists(file)) Files.createFile(file);
        } catch (IOException e) {
            throw new RuntimeException("Cannot create file: " + file, e);
        }
    }

    private List<Car> readAll() {
        try {
            return Files.readAllLines(file, StandardCharsets.UTF_8).stream()
                    .filter(line -> !line.isBlank())
                    .map(this::fromLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeAll(List<Car> cars) {
        List<String> lines = cars.stream().map(this::toLine).collect(Collectors.toList());
        try {
            Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Car fromLine(String line) {
      
        String[] p = line.split("\\|", -1);
        String id = p[0];
        String brand = p[1];
        String model = p[2];
        int year = Integer.parseInt(p[3]);
        int horsepower = Integer.parseInt(p[4]);
        int acceleration = Integer.parseInt(p[5]);
        int suspension = Integer.parseInt(p[6]);
        int durability = Integer.parseInt(p[7]);
        Car car = new Car(brand, model, year, horsepower, acceleration, suspension, durability);
        return car;
    }

    private String toLine(Car car) {
        return String.join("|",
                "", // id placeholder
                Objects.toString(car.getBrand(), ""),
                Objects.toString(car.getModel(), ""),
                Integer.toString(car.getYear()),
                Integer.toString(car.getHorsepower()),
                Integer.toString(car.getAcceleration()),
                Integer.toString(car.getSuspension()),
                Integer.toString(car.getDurability())
        );
    }

    @Override
    public synchronized void create(Car car) {
        try {
            Files.write(file, (toLine(car) + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized Car findById(String id) {
        return readAll().stream()
                .filter(c -> Objects.equals(id, carId(c))) 
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Car not found: " + id));
    }

   
    private String carId(Car car) {
        return car.getBrand() + "|" + car.getModel() + "|" + car.getYear();
    }

    @Override
    public synchronized List<Car> findAll() {
        return readAll();
    }

    @Override
    public synchronized void update(Car car) {
        List<Car> cars = readAll();
        boolean found = false;
        for (int i = 0; i < cars.size(); i++) {
            if (carId(cars.get(i)).equals(carId(car))) {
                cars.set(i, car);
                found = true;
                break;
            }
        }
        if (!found) cars.add(car);
        writeAll(cars);
    }

    @Override
    public synchronized void deleteById(String id) {
        List<Car> cars = readAll();
        boolean removed = cars.removeIf(c -> carId(c).equals(id));
        if (!removed) throw new IllegalArgumentException("Car not found: " + id);
        writeAll(cars);
    }

    @Override
    public synchronized void deleteAll() {
        writeAll(new ArrayList<>());
    }
}
