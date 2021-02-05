package definingClassesExercises.speedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carsAndDistanceMap = new LinkedHashMap<>();
        List<Car> carList = new ArrayList<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            carsAndDistanceMap.put(model, car);
        }


        String input = scanner.nextLine();
        while (!"End".equals(input)){
            String[] command = input.split("\\s+");
            String name = command[1];
            int amountOfKm = Integer.parseInt(command[2]);

            carsAndDistanceMap.get(name).drive(amountOfKm);

            input = scanner.nextLine();
        }

        carsAndDistanceMap.values().stream().forEach(c -> System.out.println(c.toString()));
    }
}
