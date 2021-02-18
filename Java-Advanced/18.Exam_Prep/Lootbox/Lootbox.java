package Lootbox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //queue
        ArrayDeque<Integer> firstLootBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        //stack
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondLootBox::push);

        int claimedItems = 0;

        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()){
            int currentFirst = firstLootBox.peek();
            int currentSecond = secondLootBox.pop();

            if ((currentFirst + currentSecond) % 2 == 0){
              claimedItems += currentFirst + currentSecond;
              firstLootBox.poll();
            } else {
                firstLootBox.offer(currentSecond);
            }
        }

        if (firstLootBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (secondLootBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100){
            System.out.printf("Your loot was epic! Value: %d", claimedItems);
        }else {
            System.out.printf("Your loot was poor... Value: %d", claimedItems);
        }
    }
}
