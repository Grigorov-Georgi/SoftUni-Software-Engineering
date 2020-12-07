import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while(!input.equals("end")){
            String[] tokens = input.split(" ");
            if (tokens[0].equals("Add")){
                wagons.add(Integer.parseInt(tokens[1]));
            }else {
                for (int i = 0; i < wagons.size() ; i++) {
                    if ((wagons.get(i) + Integer.parseInt(tokens[0])) <= maxCapacity){
                        wagons.set(i, wagons.get(i) + Integer.parseInt(tokens[0]));
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < wagons.size(); i++) {
            System.out.print(wagons.get(i) + " ");
        }
    }
}
