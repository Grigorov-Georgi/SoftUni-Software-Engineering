import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "(?<command>[A-Z][a-z]+):\\s(?<plant>[A-Z][a-z]+)(\\s-\\s(?<var>)\\d+)*";
        Pattern pattern = Pattern.compile(expression);
        String line = scanner.nextLine();
        Matcher matcher = pattern.matcher(line);

        String plant = matcher.group("plant");
        String command = matcher.group("command");
    }
}
