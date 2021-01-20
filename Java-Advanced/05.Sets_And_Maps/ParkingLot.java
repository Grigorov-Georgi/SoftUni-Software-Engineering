import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String number = tokens[1];

            switch (direction){
                case "IN":
                    cars.add(number);
                    break;
                case "OUT":
                    cars.remove(number);
                    break;
            }

            input = scanner.nextLine();
        }

        String output;

        if (!cars.isEmpty()){
            output = cars.stream().collect(Collectors.joining(System.lineSeparator()));
        }else{
            output = "Parking Lot is Empty";
        }
        System.out.println(output);
    }
}
