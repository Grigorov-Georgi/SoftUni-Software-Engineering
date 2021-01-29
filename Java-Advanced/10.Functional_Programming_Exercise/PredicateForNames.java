import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> predicate = str -> str.length() <= n;

        String[] array = scanner.nextLine().split("\\s+");

        Arrays.stream(array).filter(predicate).forEach(System.out::println);

    }
}
