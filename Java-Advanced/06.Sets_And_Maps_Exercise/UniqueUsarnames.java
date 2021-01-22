import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueUsarnames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> namesSet = new LinkedHashSet<>();

        while (n-- > 0){
            String name = scanner.nextLine();
            namesSet.add(name);
        }
        System.out.println(namesSet.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
