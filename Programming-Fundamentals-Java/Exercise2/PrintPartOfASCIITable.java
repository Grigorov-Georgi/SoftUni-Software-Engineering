import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        char a1 = (char)a;
        int b = Integer.parseInt(scanner.nextLine());
        char b1 = (char)b;
        for (char i = a1; i <= b1 ; i++) {
            System.out.printf("%s ", i);
        }
    }
}
