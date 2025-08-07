package Homeworks.homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        parkedCars.add(car);
    }

    public void tuneCars(int tuneIndex, String addOn) {
        for (Car car : parkedCars) {
            car.tune(tuneIndex, addOn);
        }
    }

    public List<Car> getParkedCars() { return parkedCars; }

    @Override
    public String toString() {
        return "Garage with " + parkedCars.size() + " cars.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkedCars);
    }
}
