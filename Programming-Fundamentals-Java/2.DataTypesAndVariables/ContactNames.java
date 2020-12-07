import java.util.Scanner;

public class ContactNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOne = scanner.nextLine();
        String nameTwo = scanner.nextLine();
        String symbols = scanner.nextLine();
        System.out.printf("%s%s%s", nameOne, symbols, nameTwo);
    }
}
