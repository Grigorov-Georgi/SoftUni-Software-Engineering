import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> chars = new LinkedHashMap<>();
        String input = scanner.nextLine();
        for (char c: input.toCharArray()) {
            if (c != ' '){
                chars.putIfAbsent(c, 0);
                int newCount = chars.get(c) + 1;
                chars.put(c, newCount);
            }
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
