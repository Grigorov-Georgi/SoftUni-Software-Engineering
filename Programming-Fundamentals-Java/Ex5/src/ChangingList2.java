import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangingList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Delete":
                    for (int i = 0; i < numbers.size() ; i++) {
                        numbers.remove(Integer.valueOf(tokens[1]));
                    }

                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(tokens[2]), Integer.valueOf(tokens[1]));
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size() ; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
