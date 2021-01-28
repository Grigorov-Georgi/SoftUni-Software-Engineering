import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUpperCase = w -> w != null && !w.isEmpty() && Character.isUpperCase(w.charAt(0));

        List<String> collect = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(collect.size());
        System.out.println(collect.stream().collect(Collectors.joining(System.lineSeparator())));
    }

}
