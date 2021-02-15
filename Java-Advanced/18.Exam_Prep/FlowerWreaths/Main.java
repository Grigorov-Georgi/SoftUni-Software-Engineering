package FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(lilies::push);

        //queue
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int wreathsCounter = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int currentLilies = lilies.pop();
            int currentRoses = roses.poll();

            while (currentLilies + currentRoses > 15) {
                currentLilies -= 2;
            }
            if (currentLilies + currentRoses == 15) {
                wreathsCounter++;
            } else if (currentLilies + currentRoses < 15) {
                storedFlowers += currentLilies + currentRoses;
            }

        }

        int wreathsWithStoredFlowers = storedFlowers / 15;

        wreathsCounter += wreathsWithStoredFlowers;

        if (wreathsCounter >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCounter);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathsCounter);
        }


    }
}
