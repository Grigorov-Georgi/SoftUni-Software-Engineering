import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String expression = "(\\*\\*|::)[A-Z][a-z]{2,}\\1";
        String exp = "(?<numbers>\\d)";
        Pattern pattern = Pattern.compile(expression);
        Pattern pattern1 = Pattern.compile(exp);
        Matcher matcher = pattern.matcher(text);
        Matcher matcher1 = pattern1.matcher(text);

        List<String> emojies = new ArrayList<>();
        List<Long> coolnes = new ArrayList<>();
        long total = 1;
        while (matcher.find()){
            emojies.add(matcher.group());
        }
        while (matcher1.find()){
            total *= Integer.parseInt(matcher1.group("numbers"));
        }

        for (int i = 0; i < emojies.size() ; i++) {
            coolnes.add(coolness(emojies.get(i)));
        }

        System.out.println("Cool threshold: " + total);
        System.out.println(emojies.size() +" emojis found in the text. The cool ones are: ");
        for (int i = 0; i < emojies.size() ; i++) {
            if (coolness(emojies.get(i)) > total){
                System.out.println(emojies.get(i));
            }
        }
    }
    public static long coolness (String word){
        long cool = 0;
        for (int i = 2; i < word.length() - 2 ; i++) {
            cool += (int) word.charAt(i);
        }
        return cool;
    }

}
