package CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardSuit[] cardSuits = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit cardSuit : cardSuits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", cardSuit.ordinal(), cardSuit.name()));
        }
    }
}
