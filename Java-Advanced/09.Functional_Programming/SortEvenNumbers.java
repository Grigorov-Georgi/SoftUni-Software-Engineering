import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(SortEvenNumbers::isEven)
                .toArray();
//                .filter(n -> isDivisibleBy(n, 2))

        System.out.println(formatArray(numbers));

        Arrays.sort(numbers);

        System.out.println(formatArray(numbers));

    }

    public static String formatArray(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }
    public static boolean isEven(int number){
        return isDivisibleBy(number, 2);
    }
    public static boolean isDivisibleBy(int n, int i) {
        return n % i == 0;
    }
}
