package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(firstLine[1]), Double.parseDouble(firstLine[2]));
        String[] secondLine = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(secondLine[1]), Double.parseDouble(secondLine[2]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            double givenNumber = Double.parseDouble(tokens[2]);
            switch (tokens[0]) {
                case "Drive":
                    if (tokens[1].equals("Car")){
                        System.out.println(car.drive(givenNumber));
                    }else{
                        System.out.println(truck.drive(givenNumber));
                    }
                    break;
                case "Refuel":
                    if (tokens[1].equals("Car")){
                        car.refuel(givenNumber);
                    }else{
                        truck.refuel(givenNumber);
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck);
    }
}
