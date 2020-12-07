import java.util.Random;
import java.util.Scanner;

public class RandomWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");
        Random randomGenerator = new Random();

        for (int i = 0; i < words.length ; i++) {
            String oldWord = words[i];
            int x = randomGenerator.nextInt(words.length);
            words[i] = words[x];
            words[x] = oldWord;
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
