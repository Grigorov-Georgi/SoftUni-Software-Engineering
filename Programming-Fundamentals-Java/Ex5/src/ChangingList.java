import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")){
         String[] tokens = input.split("\\s+");
         if (tokens[0].equals("Delete")){
             int n = 0;
             while (n < numbers.size()){
                 numbers.remove(Integer.valueOf(tokens[1]));
                 n++;
             }
         }else{
             numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
         }

            input = scanner.nextLine();
        }

        for (int i = 0; i < numbers.size() ; i++) {
            System.out.print(numbers.get(i) + "");
        }
    }
}
