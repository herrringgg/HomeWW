package Homeworks.homework07;

import java.util.Objects;

public class DiscountProduct extends Product {

    private int discount;
    private boolean discountDate = false;


    public DiscountProduct(String nameProduct, double price, int discount, boolean discountDate) {
        super(nameProduct, price);
        this.discount = discount;
        this.discountDate = discountDate;
    }

    public boolean isDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(boolean discountDate) {
        this.discountDate = discountDate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount && discountDate == that.discountDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountDate);
    }

    @Override
    public double getPrice() {
        if (discountDate) {
            return super.getPrice() * (100 - discount) / 100.0;
        } else {
            return super.getPrice();
        }
    }
}
