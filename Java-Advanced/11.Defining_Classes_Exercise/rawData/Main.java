package definingClassesExercises.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        while(n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tirePressure1 = Double.parseDouble(tokens[5]);
            int tireAge1 = Integer.parseInt(tokens[6]);
            double tirePressure2 = Double.parseDouble(tokens[7]);
            int tireAge2 = Integer.parseInt(tokens[8]);
            double tirePressure3 = Double.parseDouble(tokens[9]);
            int tireAge3 = Integer.parseInt(tokens[10]);
            double tirePressure4 = Double.parseDouble(tokens[11]);
            int tireAge4 = Integer.parseInt(tokens[12]);

            Car car = new Car(model);
            Engine engine = new Engine(engineSpeed, enginePower);
            car.setEngine(engine);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            car.setCargo(cargo);

            Tire tire1 = new Tire(tirePressure1, tireAge1);
            car.setTire1(tire1);

            Tire tire2 = new Tire(tirePressure2, tireAge2);
            car.setTire2(tire2);

            Tire tire3 = new Tire(tirePressure3, tireAge3);
            car.setTire3(tire3);

            Tire tire4 = new Tire(tirePressure4, tireAge4);
            car.setTire4(tire4);

            carList.add(car);
        }

        String input = scanner.nextLine();
        switch (input){
            case "fragile":
                for (Car car : carList) {
                    if (car.fragile()){
                        System.out.println(car.getModel());
                    }
                }
                break;
            case "flamable":
                for (Car car : carList) {
                    if (car.flamable()){
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }
}
