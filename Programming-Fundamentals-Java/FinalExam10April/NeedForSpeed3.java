import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed3 {

    public static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public String getName() {
            return name;
        }

        public int getMileage() {
            return mileage;
        }

        public int getFuel() {
            return fuel;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            String name = line[0];
            int mileage = Integer.parseInt(line[1]);
            int fuel = Integer.parseInt(line[2]);
            Car car = new Car(name, mileage, fuel);
            carMap.put(name, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String car = tokens[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int currentMileage = carMap.get(car).getMileage();
                    int fuel = Integer.parseInt(tokens[3]);
                    int currentFuel = carMap.get(car).getFuel();

                    if (fuel > currentFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carMap.get(car).setFuel(currentFuel - fuel);
                        carMap.get(car).setMileage(distance + currentMileage);
                        System.out.println(car + " driven for " + distance + " kilometers. " + fuel + " liters of fuel consumed.");
                        if (carMap.get(car).getMileage() >= 100_000) {
                            System.out.println("Time to sell the " + car + "!");
                            carMap.remove(car);
                        }
                    }

                    break;
                case "Refuel":
                    int refuelLiters = Integer.parseInt(tokens[2]);
                    int currentLiters = carMap.get(car).getFuel();
                    int usedLiters;
                    if (currentLiters + refuelLiters > 75) {
                        usedLiters = 75 - currentLiters;
                    } else {
                        usedLiters = refuelLiters;
                    }
                    carMap.get(car).setFuel(currentLiters + usedLiters);
                    System.out.println(car + " refueled with " + usedLiters + " liters");
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    int currentKilometers = carMap.get(car).getMileage();

                    if (currentKilometers - kilometers <= 10_000) {
                        carMap.get(car).setMileage(10_000);
                    } else {
                        carMap.get(car).setMileage(currentKilometers - kilometers);
                        System.out.println(car + " mileage decreased by " + kilometers + " kilometers");
                    }
                    break;
            }


            input = scanner.nextLine();
        }

//        carMap.values()
//                .stream()
//                .sorted((a, b) -> {
//                    int aMile = a.getMileage();
//                    int bMile = b.getMileage();
//
//                    if (aMile != bMile) {
//                        return Integer.compare(bMile, aMile);
//                    } else {
//                        return a.getName().compareTo(b.getName());
//                    }
//                }).forEach(car -> System.out.println(car.getName() + " -> Mileage: " + car.getMileage() + " kms, Fuel in the tank: " + car.getFuel() + " lt."));

        carMap.values().stream().sorted((Comparator.comparing(Car::getMileage).reversed()).thenComparing(Car::getName)).forEach(car -> System.out.println(car.getName() + " -> Mileage: " + car.getMileage() + " kms, Fuel in the tank: " + car.getFuel() + " lt."));
    }

}
