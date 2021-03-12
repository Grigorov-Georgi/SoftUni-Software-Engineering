package vehicleExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(firstLine[1]), Double.parseDouble(firstLine[2]), Double.parseDouble(firstLine[3]));

        String[] secondLine = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(secondLine[1]), Double.parseDouble(secondLine[2]), Double.parseDouble(secondLine[3]));

        String[] thirdLine = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(thirdLine[1]), Double.parseDouble(thirdLine[2]), Double.parseDouble(thirdLine[3]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            double givenNumber = Double.parseDouble(tokens[2]);
            try {
                switch (tokens[0]) {
                    case "Drive":
                        if (tokens[1].equals("Car")) {
                            System.out.println(car.drive(givenNumber));
                        } else if (tokens[1].equals("Truck")) {
                            System.out.println(truck.drive(givenNumber));
                        } else {
                            System.out.println(bus.drive(givenNumber));
                        }
                        break;
                    case "Refuel":
                        if (tokens[1].equals("Car")) {
                            car.refuel(givenNumber);
                        } else if (tokens[1].equals("Truck")) {
                            truck.refuel(givenNumber);
                        } else {
                            bus.refuel(givenNumber);
                        }
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
