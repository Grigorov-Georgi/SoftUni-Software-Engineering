import java.util.List;
import java.util.Scanner;

public class EsterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggsPrice = flourPrice * 0.75;
        double milk = flourPrice * 1.25 / 4;
        double totalPrice = milk + eggsPrice + flourPrice;
        int coloredEggs = 0;
        int cozonacs = 0;

        while (budget - totalPrice >= 0){
            budget -= totalPrice;
            cozonacs ++;
            coloredEggs += 3;
            if (cozonacs % 3 == 0){
                coloredEggs -= cozonacs - 2;
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", cozonacs, coloredEggs, budget);

    }

}

