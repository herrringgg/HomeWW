package Homeworks.homework11;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("a123me", "Mercedes", "White", 0, 8300000),
                new Car("b873of", "Volga", "Black", 0, 673000),
                new Car("w487mn", "Lexus", "Grey", 76000, 900000),
                new Car("p987hj", "Volga", "Red", 610, 704340),
                new Car("c987ss", "Toyota", "White", 254000, 761000),
                new Car("o983op", "Toyota", "Black", 698000, 740000),
                new Car("p146op", "BMW", "White", 271000, 850000),
                new Car("u893ii", "Toyota", "Purple", 210900, 440000),
                new Car("l097df", "Toyota", "Black", 108000, 780000),
                new Car("y876wd", "Toyota", "Black", 160000, 1000000)
        );


        System.out.println("Автомобили в базе:");
        System.out.println("Номер Модель Цвет Пробег Цена");
        cars.forEach(System.out::println);


        cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .ifPresent(car -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + car.getColor()));


        printAverageCostForModel(cars, "Toyota");
        printAverageCostForModel(cars, "Volvo");
    }

    public static void printAverageCostForModel(List<Car> cars, String model) {
        OptionalDouble avg = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .mapToLong(Car::getCost)
                .average();

        double averageCost = avg.orElse(0);
        System.out.printf("Средняя стоимость модели %s: %.2f%n", model, averageCost);
    }
}

