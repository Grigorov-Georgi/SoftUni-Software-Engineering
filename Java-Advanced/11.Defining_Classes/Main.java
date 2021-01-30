import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n = Integer.parseInt(scanner.nextLine());
//
//        while (n-- > 0) {
//            String[] tokens = scanner.nextLine().split("\\s+");
//
//            Car car;
//            if (tokens.length == 1) {
//                car = new Car(tokens[0]);
//            } else {
//                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
//            }
//
//            System.out.print(car.toString());
//            System.out.println();
//        }

        Map<Integer, BankAccount> vault = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String output;
            switch (tokens[0]) {
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (!vault.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        vault.get(id).deposit(amount);
                        output = "Deposited " + amount + " to ID" + id;
                    }
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (!vault.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        output = String.format("%.2f", vault.get(id).getInterest(years));
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                    output = null;
                    break;
                default:
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }

    }
}
