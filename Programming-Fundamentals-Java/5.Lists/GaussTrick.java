import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseIntegersList(scanner);

        List<Integer> sumOfNumber = new ArrayList<>();


        for (int i = 0; i < numbers.size() / 2 ; i++) {
                sumOfNumber.add(numbers.get(i) + numbers.get(numbers.size() - 1 -i));
        }
        if (numbers.size() % 2 != 0){
            sumOfNumber.add(numbers.get(numbers.size() / 2));
        }

        for (int number : sumOfNumber) {
            System.out.print(number + " ");
        }
    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static List<Integer> parseIntegersList(Scanner scanner) {
        String line = scanner.nextLine();
        String[] array = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
