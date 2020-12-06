import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        order(scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
    }
    static void order(String product, int quantity){
        double price = 0;
        switch (product){
            case "water":
                price = 1;
                break;
            case "coffee":
                price = 1.5;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }
        System.out.printf("%.2f",price * quantity);
    }
}
