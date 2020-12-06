import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int yieldForTheDay = 0;
        int allYield = 0;
        while (startingYield >= 100) {
            days++;
            yieldForTheDay = startingYield - 26;
            allYield += yieldForTheDay;
            startingYield -= 10;
        }
        if (allYield < 48) {
            System.out.println(0);
            System.out.println(0);
        } else {
            allYield -= 26;
            System.out.println(days);
            System.out.println(allYield);
        }
    }
}
