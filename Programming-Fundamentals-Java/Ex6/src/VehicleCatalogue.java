import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        int hp;

        Vehicle(String type, String model, String color, int hp) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.hp = hp;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHp() {
            return hp;
        }

        public String toString() {
                return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1),  getModel(), getColor(), getHp());
        }
    }
    public static double averageHorsepower (List<Vehicle> vehicles){
        if (vehicles.size() == 0){
            return 0.0;
        }

        return vehicles.stream().mapToDouble(Vehicle:: getHp).sum()/vehicles.size();


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> allVehicles = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] array = input.split(" ");
            Vehicle vehicle = new Vehicle(array[0], array[1], array[2], Integer.parseInt(array[3]));
            allVehicles.add(vehicle);
            input = scanner.nextLine();
        }

        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
//            for (int i = 0; i < allVehicles.size(); i++) {
//                if (allVehicles.get(i).getModel().equals(secondInput)) {
//                    System.out.println(allVehicles.get(i).toString());
//                }
//            }
            String m = model;
            allVehicles.stream().
                    filter(vehicle -> vehicle.getModel().equals(m))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));

            model = scanner.nextLine();
        }
        List<Vehicle> cars = allVehicles.stream().filter(vehicle -> vehicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehicle> trucks = allVehicles.stream().filter(vehicle -> vehicle.getType().equals("truck")).collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsepower(trucks));
    }
}
