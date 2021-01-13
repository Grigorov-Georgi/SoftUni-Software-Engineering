import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> indexesOfOpeningBrackets = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '('){
                indexesOfOpeningBrackets.push(i);
            }else if (symbol == (')')){
                System.out.println(input.substring(indexesOfOpeningBrackets.pop(), i + 1));
            }
        }
    }
}
