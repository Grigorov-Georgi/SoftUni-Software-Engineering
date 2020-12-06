import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DigitsLettersandOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder numbers = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < input.length() ; i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)){
                numbers.append(current);
            }else if (Character.isAlphabetic(current)){
                letters.append(current);
            }else {
                symbols.append(current);
            }
        }
        System.out.println(numbers.toString());
        System.out.println(letters.toString());
        System.out.println(symbols.toString());
    }
}
