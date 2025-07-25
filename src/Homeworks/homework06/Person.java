package Homeworks.homework06;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private Product[] products = new Product[0];
    //поля




    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
    }

    public Person(String params) {
        String[] paramArray = params.split("=");
        this.name = paramArray[0].trim();
        this.money = Double.valueOf(paramArray[1].trim());
    }
    // конструктор


    public String getName() {

        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Имя не может быть пустым");
        }
    }



    public double getMoney() {

        return money;
    }
    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            System.out.println("Деньги не могут быть отрицательными");
        }
    }

    public Product[] getProducts() {

        return products;
    }

    public String addProducts(Product product) {
        if (this.money >= product.getPrice()) {
            products = Arrays.copyOf(products, products.length + 1);
            products[products.length - 1] = product;
            this.money = this.money - product.getPrice();
            String okonchanie = "купил";
            if (this.name.trim().equals("Анна Петровна") || this.name.trim().equals("Света")) {
                okonchanie = "купила";
            }
            return this.name + " " + okonchanie + " " + product.getNameProduct();

        } else {
            return this.name + " не может позволить себе " + product.getNameProduct();
        }
    }

    //гетСет


    @Override
    public String toString() {
        if (products.length == 0) {
            return name + " - Ничего не куплено";
        }
        return name + " - " + Arrays.stream(products)
                .map(Product::getNameProduct)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(money, person.money) == 0 && Objects.equals(name, person.name) && Objects.deepEquals(products, person.products);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, money, Arrays.hashCode(products));
    }
}
