import java.util.Scanner;

public class RageExpensess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loses = Integer.parseInt(scanner.nextLine());
        double headset = Double.parseDouble(scanner.nextLine());
        double mouse = Double.parseDouble(scanner.nextLine());
        double keyboard = Double.parseDouble(scanner.nextLine());
        double display = Double.parseDouble(scanner.nextLine());
        int head = 0;
        int mou = 0;
        int key = 0;
        int disp = 0;

        head = loses / 2;
        mou = loses / 3;
        key = loses / 6;
        disp = loses / 12;
        double sum = head * headset + mou * mouse + key * keyboard + disp * display;
        System.out.printf("Rage expenses: %.2f", sum);
    }
}
