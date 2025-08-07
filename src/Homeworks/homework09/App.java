package Homeworks.homework09;

public class App {
    public static void main(String[] args) {
        Garage garage = new Garage();

        PerformanceCar pCar = new PerformanceCar("Lamborghini", "Huracan Evo", 2022, 630, 3, 85, 70);
        ShowCar sCar = new ShowCar("Rolls-Royce", "Wraith", 2021, 563, 5, 75, 95);

        garage.parkCar(pCar);
        garage.parkCar(sCar);

        System.out.println(" Before tuning:");
        garage.getParkedCars().forEach(System.out::println);

        garage.tuneCars(50, "Drift Setup");

        System.out.println("\n After tuning:");
        garage.getParkedCars().forEach(System.out::println);

        Race race = new CasualRace(4000, "Ле-Ман", 10045);
        race.addParticipant(pCar);
        race.addParticipant(sCar);

        System.out.println("\n" + race.startRace());
    }
}
