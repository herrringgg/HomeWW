package Homeworks.homework09;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar() {
        super();
        this.addOns = new ArrayList<>();
    }

    public PerformanceCar(String brand, String model, int year, int horsepower,
                          int acceleration, int suspension, int durability) {
        super(brand, model, year, (int)(horsepower * 1.5),
                acceleration, (int)(suspension * 0.75), durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        super.tune(tuneIndex, addOn);
        this.addOns.add(addOn);
    }

    public List<String> getAddOns() { return addOns; }

    @Override
    public String toString() {

        return super.toString() + String.format(" [PerformanceCar] AddOns: %s",
                addOns.isEmpty() ? "None" : String.join(", ", addOns));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addOns);
    }
}
