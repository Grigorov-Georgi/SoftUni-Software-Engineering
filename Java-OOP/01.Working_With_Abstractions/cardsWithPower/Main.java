package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getPower(scanner));
    }

    public static String getPower(Scanner scanner){
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        return String.format("Card name: %s of %s; Card power: %s", rank, suit,
                (CardRank.valueOf(rank).getRankPower() + CardSuit.valueOf(suit).getPower()));
    }
}
