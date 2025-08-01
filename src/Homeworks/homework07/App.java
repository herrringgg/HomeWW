package Homeworks.homework07;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Product[] normalProducts = new Product[100];
        Product[] discountProducts = new Product[100];
        int normalCount = 0;
        int discountCount = 0;


        System.out.println("Начинаем заполнение корзины: ");


        String[] inputLines = new String[100];
        int inputCount = 0;

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("END"))
                break;
            inputLines[inputCount++] = line;
        }


        for (int i = 0; i < inputCount; i++) {
            String line = inputLines[i];


            if (!line.contains("=")) {
                System.out.println("Неверный формат строки!");
                continue;
            }

            String[] parts = line.split("=");
            String name = parts[0].trim();


            if (name.length() < 3 || name.matches("\\d+")) {
                System.out.println("Недопустимое имя продукта!");
                continue;
            }

            String rightPart = parts[1].trim();
            if (rightPart.contains("%")) {
                String[] priceAndDiscount = rightPart.split(",");
                if (priceAndDiscount.length != 2) {
                    System.out.println("Неверный формат скидочного продукта!");
                    continue;
                }

                double price = Double.parseDouble(priceAndDiscount[0].trim());
                int discount = Integer.parseInt(priceAndDiscount[1].trim().replace("%", ""));

                if (price <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                    continue;
                }

                DiscountProduct dp = new DiscountProduct(name, price, discount, true);
                discountProducts[discountCount++] = dp;
            } else {
                double price = Double.parseDouble(rightPart);
                if (price <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                    continue;
                }

                Product p = new Product(name, price);
                normalProducts[normalCount++] = p;
            }
        }


        System.out.print("Обычные продукты: ");
        if (normalCount == 0) {
            System.out.println("нет");
        } else {
            for (int i = 0; i < normalCount; i++) {
                System.out.print(normalProducts[i].getNameProduct());
                if (i != normalCount - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.print("Акционные продукты: ");
        if (discountCount == 0) {
            System.out.println("нет");
        } else {
            for (int i = 0; i < discountCount; i++) {
                System.out.print(discountProducts[i].getNameProduct());
                if (i != discountCount - 1) System.out.print(", ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

