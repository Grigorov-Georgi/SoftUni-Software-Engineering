import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        List<String > numbers = new ArrayList<>();

        while (matcher.find()){
            numbers.add(matcher.group(0));
        }
        System.out.println(String.join(", ", numbers));
    }
}
