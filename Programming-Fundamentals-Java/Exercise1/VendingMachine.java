import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0;
        double coinValue = 0;
        double price = 0;
        boolean doesThisProductExist = true;
        while (!input.equals("Start")) {
            coinValue = Double.parseDouble(input);
            if (coinValue != 0.1 && coinValue != 0.2 && coinValue != 0.5 && coinValue != 1 && coinValue != 2) {
                System.out.printf("Cannot accept %.2f%n", coinValue);
            } else {
                sum += coinValue;
            }
            input = scanner.nextLine();

        }
        input = scanner.nextLine();
        while (!input.equals("End")){
            switch (input){
                case "Nuts":
                    price = 2;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    doesThisProductExist = false;
            }
            if (!doesThisProductExist){
                doesThisProductExist = true;
                input = scanner.nextLine();
                continue;
            }
            if (price > sum){
                System.out.println("Sorry, not enough money");

            }else{
                sum -=price;
                System.out.printf("Purchased %s%n", input);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", sum);
    }
}