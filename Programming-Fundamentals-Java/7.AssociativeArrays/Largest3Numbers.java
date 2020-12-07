import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        List<Integer> input = Arrays.stream(numbers).map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1)).limit(3).collect(Collectors.toList());
        for (int n: input) {
            System.out.print(n + " ");
        }
    }
}
