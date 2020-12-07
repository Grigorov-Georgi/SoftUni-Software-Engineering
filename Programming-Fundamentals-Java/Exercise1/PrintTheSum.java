import java.util.Scanner;

public class PrintTheSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int total = 0;
        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");
            total += i;
        }
        System.out.println();
        System.out.println("Sum: " + total);
    }
}
