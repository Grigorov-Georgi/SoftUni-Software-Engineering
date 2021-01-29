import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestElement = l -> l.stream().min(Integer::compare).get();

        int lastIndex = list.lastIndexOf(findSmallestElement.apply(list));
        System.out.println(lastIndex);
    }
}
