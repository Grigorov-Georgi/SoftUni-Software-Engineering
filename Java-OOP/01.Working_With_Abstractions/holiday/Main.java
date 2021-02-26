package holiday;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        runHoliday(scanner);
    }

    private static void runHoliday(Scanner scanner) {
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        PriceCalculator priceCalculator = new PriceCalculator(Double.parseDouble(tokens[0]),
                Integer.parseInt(tokens[1]),
                Seasons.valueOf(tokens[2].toUpperCase()),
                DiscountType.valueOf(tokens[3].toUpperCase()));
        System.out.println(priceCalculator.toString());
    }
}
