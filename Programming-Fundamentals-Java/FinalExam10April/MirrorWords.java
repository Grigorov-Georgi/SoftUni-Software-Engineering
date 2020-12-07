import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String expression = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        Map<String, String> pairs = new LinkedHashMap<>();
        List<String> wordPairs = new ArrayList<>();
        while (matcher.find()) {
            counter++;
            StringBuilder sb = new StringBuilder();
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            sb.append(secondWord);
            sb.reverse();
            String secondWordreversed = sb.toString();
            if (firstWord.equals(secondWordreversed)) {
                pairs.put(firstWord, secondWord);
                String formated = firstWord + " <=> " + secondWord;
                wordPairs.add(formated);

            }
        }
        if (counter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(counter + " word pairs found!");

        }
        if (wordPairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are: ");
            System.out.println(String.join(", ", wordPairs));
        }


    }
}
