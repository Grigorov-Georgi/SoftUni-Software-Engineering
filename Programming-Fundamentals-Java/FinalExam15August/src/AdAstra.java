import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static class Food{
        String name;
        String date;
        int cal;

        public Food(String name, int cal) {
            this.name = name;
            this.cal = cal;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setCal(int cal) {
            this.cal = cal;
        }

        public String getName() {
            return name;
        }

        public int getCal() {
            return cal;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String expression = "([|#])(?<item>[A-Za-z]+( [A-Za-z]+)*)\\1(?<date>(0\\d|\\d\\d)/(0\\d|\\d\\d)/(0\\d|\\d\\d))\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        List<String> foods = new ArrayList<>();
        int total = 0;
        while (matcher.find()){
            total += Integer.parseInt(matcher.group("calories"));
            foods.add(String.format("Item: %s, Best before: %s, Nutrition: %s", matcher.group("item"), matcher.group("date"), matcher.group("calories")));
        }
        int days = Math.round(total / 2000);
        System.out.println("You have food to last you for: " + days + " days!");
        foods.stream().forEach(s -> System.out.println(s));
    }
}
