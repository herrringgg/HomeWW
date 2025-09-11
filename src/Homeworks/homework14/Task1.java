package Homeworks.homework14;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные о людях (например: Иван=100;Анна=200): ");
        String[] personsArray = scanner.nextLine().split(";");
        Person[] people = new Person[personsArray.length];
        for (int i = 0; i < personsArray.length; i++) {
            people[i] = new Person(personsArray[i]);
        }

        System.out.println("Введите данные о продуктах (например: Хлеб=50;Молоко=70): ");
        String[] productArray = scanner.nextLine().split(";");
        Product[] products = new Product[productArray.length];
        for (int i = 0; i < productArray.length; i++) {
            products[i] = new Product(productArray[i]);
        }

        List<String> purchaseLog = new ArrayList<>();
        System.out.println("\n--- Начинаем покупки (пример: Иван-Хлеб). Для выхода: END ---");
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("END")) {
            String[] input = line.split("-");
            if (input.length == 2) {
                String personName = input[0].trim();
                String productName = input[1].trim();
                for (Person person : people) {
                    if (person.getName().equals(personName)) {
                        for (Product product : products) {
                            if (product.getNameProduct().equals(productName)) {
                                String resultMessage = person.addProducts(product);
                                purchaseLog.add(resultMessage);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            line = scanner.nextLine();
        }

        for (String message : purchaseLog) {
            System.out.println(message);
        }

        System.out.println("\n--- Итоги ---");
        for (Person person : people) {
            System.out.println(person);
        }
        scanner.close();
    }
}
