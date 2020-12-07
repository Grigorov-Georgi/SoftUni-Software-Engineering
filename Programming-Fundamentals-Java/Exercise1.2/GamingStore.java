import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        String name = scanner.nextLine();
        double price = 0;
        double startBalance = balance;
        while (!name.equals("Game Time")) {
            switch (name) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
            }
            if (price != 0 && (balance - price) >= 0) {
                System.out.printf("Bought %s%n", name);
                balance -= price;
                if (balance == 0){
                        System.out.println("Out of money");
                        return;
                    }
                } else if ((balance - price) < 0) {
                System.out.println("Too Expensive");
            }

            name = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", startBalance - balance, balance);
    }
}
