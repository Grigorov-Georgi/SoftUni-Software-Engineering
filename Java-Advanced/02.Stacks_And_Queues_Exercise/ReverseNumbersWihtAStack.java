import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWihtAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> normal = new ArrayDeque<>();

        for (int i = 0; i < input.length ; i++) {
            normal.push(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < input.length ; i++) {
            System.out.print(normal.pop() + " ");
        }

    }
}
