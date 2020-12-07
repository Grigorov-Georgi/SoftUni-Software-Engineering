import java.util.Scanner;

public class ComputerScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        double tax = 0;
        double total = 0;
        while (true) {
            if (input.equals("special")) {
                tax = sum * 0.2;
                total = (sum + tax) * 0.9;
                break;
            }
            if (input.equals("regular")) {
                tax = sum * 0.2;
                total = (sum + tax);
                break;
            }
            if (Double.parseDouble(input) < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }

            sum += Double.parseDouble(input);


            input = scanner.nextLine();
        }
        if (total == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!%nPrice without taxes: %.2f$%nTaxes: %.2f$%n-----------%nTotal price: %.2f$", sum, tax, total);
        }
    }
}
