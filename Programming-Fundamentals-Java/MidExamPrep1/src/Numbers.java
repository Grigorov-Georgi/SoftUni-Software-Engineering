import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String[] arr = scanner.nextLine().split("\\s+");
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            numbers.add(Integer.parseInt(arr[i]));
            sum += numbers.get(i);
        }
        double average = sum * 1.0 / arr.length;
        List<Integer> newN = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            if (numbers.get(i) > average){
                newN.add(numbers.get(i));
            }
        }
        if (newN.size() == 0){
            System.out.println("No");
            return;
        }
        int counter = 0;
        newN.sort((n1, n2) -> Integer.compare(n2, n1));
        for (int n : newN) {
            System.out.print(n + " ");
            counter++;
            if (counter == 5){
                return;
            }
        }
    }
}
