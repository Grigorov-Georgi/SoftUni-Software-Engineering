package definingClassesExercises.carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engineMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = null;

            if (tokens.length == 3) {

                if (Character.isAlphabetic(tokens[2].charAt(0))) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                } else {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                }

            } else if (tokens.length == 4) {

                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);

            } else if (tokens.length == 2) {

                engine = new Engine(model, power);

            }
            engineMap.put(model, engine);
        }

        List<Car> carList = new ArrayList<>();

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String neededEngine = tokens[1];

            Car car = null;

            if (tokens.length == 3) {

                if (Character.isAlphabetic(tokens[2].charAt(0))) {
                    String color = tokens[2];
                    car = new Car(model, engineMap.get(neededEngine), color);
                } else {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engineMap.get(neededEngine), weight);
                }

            } else if (tokens.length == 4) {

                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];

                car = new Car(model, engineMap.get(neededEngine), weight, color);

            } else if (tokens.length == 2) {

                car = new Car(model, engineMap.get(neededEngine));

            }
            carList.add(car);
        }

        carList.forEach(c -> System.out.println(c.toString()));

    }
}
