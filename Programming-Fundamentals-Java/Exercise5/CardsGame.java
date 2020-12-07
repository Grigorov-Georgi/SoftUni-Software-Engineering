import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOne = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
            int first = playerOne.get(0);
            int second = playerTwo.get(0);
            playerOne.remove(0);
            playerTwo.remove(0);
            if (first > second) {
                playerOne.add(first);
                playerOne.add(second);
            } else if (second > first) {
                playerTwo.add(second);
                playerTwo.add(first);
            }
        }
        int sum = 0;
        if (playerOne.isEmpty()) {
            for (int number : playerTwo) {
                sum += number;
            }
            System.out.println("Second player wins! Sum: " + sum);
        } else {
            for (int number : playerOne) {
                sum += number;
            }
            System.out.println("First player wins! Sum: " + sum);
        }

    }
}
