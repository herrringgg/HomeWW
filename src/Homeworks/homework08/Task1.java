package Homeworks.homework08;

import Homeworks.homework06.Person;
import Homeworks.homework06.Product;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Task1 {
    public static void main(String[] args) {
        List<String> purchaseLog = new ArrayList<>();

        Person[] people = null;
        Product[] products = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Homeworks/homework08/input.txt"))) {

            String personsLine = reader.readLine();
            String[] personsArray = personsLine.split(";");


            String productsLine = reader.readLine();
            String[] productArray = productsLine.split(";");

            people = new Person[personsArray.length];
            for (int i = 0; i < personsArray.length; i++) {
                people[i] = new Person(personsArray[i]);
            }

            products = new Product[productArray.length];
            for (int i = 0; i < productArray.length; i++) {
                products[i] = new Product(productArray[i]);
            }


            String line = reader.readLine();
            while (line != null && !line.equalsIgnoreCase("END")) {
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
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String message : purchaseLog) {
                writer.write(message);
                writer.newLine();
            }
            writer.newLine();

            for (Person person : people) {
                writer.write(person.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
