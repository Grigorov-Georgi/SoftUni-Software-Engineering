import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String line = scanner.nextLine();
        String[] array = line.split("\\s+");
        int bombNum = Integer.parseInt(array[0]);
        int power = Integer.parseInt(array[1]);

        while(numbers.contains(bombNum)){
            int bombPosition = numbers.indexOf(bombNum);
            int leftBound = Math.max(0, bombPosition - power);
            int rightBound = Math.min(numbers.size() - 1, bombPosition + power);
            for (int i = rightBound; i >= leftBound ; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);

    }
}
