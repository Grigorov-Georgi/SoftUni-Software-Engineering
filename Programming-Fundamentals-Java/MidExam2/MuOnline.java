import java.sql.SQLOutput;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playersHP = 100;
        int bitcoins = 0;
        int rooms = 0;
        String[] arr = scanner.nextLine().split("\\|");
        for (int i = 0; i < arr.length; i++) {
            String[] tokens = arr[i].split(" ");
            String a = tokens[0];
            int b = Integer.parseInt(tokens[1]);
            switch (a) {
                case "potion":
                    int heal = b;
                    if (playersHP + heal <= 100) {
                        playersHP += heal;
                        System.out.println("You healed for " + heal + " hp.");
                        System.out.println("Current health: " + playersHP + " hp.");
                    } else {
                        int currentHeal = 100 - playersHP;
                        playersHP = 100;
                        System.out.println("You healed for " + currentHeal + " hp.");
                        System.out.println("Current health: " + playersHP + " hp.");
                    }
                    rooms++;
                    break;
                case "chest":
                    bitcoins += b;
                    System.out.println("You found " + b + " bitcoins.");
                    rooms++;
                    break;
                default:
                    int damage = b;
                    rooms++;
                    if (playersHP - b > 0) {
                        playersHP -= b;
                        System.out.println("You slayed " + a + ".");
                    } else {
                        System.out.println("You died! Killed by " + a + ".");
                        System.out.println("Best room: " + rooms);
                        return;
                    }

                    break;

            }
        }
        System.out.println("You've made it!");
        System.out.println("Bitcoins: " + bitcoins);
        System.out.println("Health: " + playersHP);

    }
}
