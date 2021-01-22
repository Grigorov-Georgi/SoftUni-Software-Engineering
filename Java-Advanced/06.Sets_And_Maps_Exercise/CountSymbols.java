import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> charAndOccurrences = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length() ; i++) {
            charAndOccurrences.putIfAbsent(input.charAt(i), 0);
            charAndOccurrences.put(input.charAt(i), charAndOccurrences.get(input.charAt(i)) + 1);
        }

        charAndOccurrences.forEach((k, v) -> System.out.printf("%s: %d time/s%n", k,v));
    }
}
