import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = ">>(?<name>[A-Z][A-za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile(expression);
        double sum = 0;
        List<String> list = new ArrayList<>();

        while (!text.equals("Purchase")){
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                list.add(matcher.group("name"));
                sum += Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
            }
            text = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(String.format("Total money spend: %.2f", sum));
    }

}
