import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        fistColumns(n);
        secondColumns(n);
    }

    public static void fistColumns(int n){
        for (int i = 1; i <= n ; i++) {
            line(i);
        }

    }
    public static void secondColumns(int n){
        for (int i = n - 1; i >= 1 ; i--) {
            line(i);
        }

    }
    public static void line(int number){
        for (int i = 1; i <= number ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
