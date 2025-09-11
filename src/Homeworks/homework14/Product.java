package Homeworks.homework14;

import java.util.Objects;

public class Product {
    private String nameProduct;
    private double price;

    public Product(String nameProduct, double price) {
        setNameProduct(nameProduct);
        setPrice(price);
    }

    public Product(String params) {
        String[] paramArray = params.split("=");
        this.nameProduct = paramArray[0].trim();
        this.price = Double.parseDouble(paramArray[1].trim());
    }

    public Product() {
        this.nameProduct = "личи";
        this.price = 0.0;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        if (nameProduct == null || nameProduct.isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return nameProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 &&
                Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }
}