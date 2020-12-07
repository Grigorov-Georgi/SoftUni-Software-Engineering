import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
            text = text.replace(word, repeat(word));
        }
        System.out.println(text);

    }

    private static String repeat(String word) {
        String replacement = "";
        for (int i = 0; i <word.length() ; i++) {
            replacement = replacement.concat("*");
        }
        return replacement;
    }

}
