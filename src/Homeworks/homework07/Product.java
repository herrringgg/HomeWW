package Homeworks.homework07;

import java.util.Objects;

public class Product {
    protected String nameProduct;
    protected double price;



    public Product(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public Product(String paramss) {
        String[] paramssArray = paramss.split("=");
        this.nameProduct = paramssArray[0].trim();
        this.price = Double.valueOf(paramssArray[1].trim());
    }

    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        if (!nameProduct.isEmpty()) {
            this.nameProduct = nameProduct;
        } else {
            System.out.println("Название продукта не может быть пустым");
        }
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательной"); }
    }




    @Override
    public String toString() {
        return nameProduct;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }
}

