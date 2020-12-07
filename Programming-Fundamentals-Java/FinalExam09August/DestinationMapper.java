import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String exp = "([=/])(?<city>[A-Z][A-Za-z][A-Za-z]+)\\1";
        Pattern pattern = Pattern.compile(exp);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        List<String> destination = new ArrayList<>();
        while (matcher.find()){
            destination.add(matcher.group("city"));
        }
        int sum = 0;
        for (int i = 0; i < destination.size() ; i++) {
            sum += destination.get(i).length();
        }
        System.out.println("Destinations: " + String.join(", ", destination));
        System.out.println("Travel Points: " + sum);
    }
}
