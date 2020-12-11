import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "(?<needed>[^\\d]+)(?<times>\\d+)";
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        StringBuilder sb = new StringBuilder();

        List<String> usedSymbolsList = new ArrayList<>();
        while (matcher.find()){
            String needed = matcher.group("needed");
            String[] tokens = needed.split("");
            for (int i = 0; i < tokens.length ; i++) {
                if (!usedSymbolsList.contains(tokens[i].toLowerCase())){
                    usedSymbolsList.add(tokens[i].toLowerCase());
                }
            }
            int times = Integer.parseInt(matcher.group("times"));
            for (int i = 0; i < times ; i++) {
                sb.append(needed.toUpperCase());
            }
        }
        System.out.println(String.format("Unique symbols used: %d%n%s", usedSymbolsList.size(), sb.toString()));
    }
}
