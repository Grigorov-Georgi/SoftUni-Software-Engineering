import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        topNumbers(number);
    }

    public static boolean oddDigit(int number) {
        int lastDigit = 0;
        while (number > 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    public static boolean sumEqual8(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;
    }

    static void topNumbers(int max) {
        for (int i = 1; i <= max ; i++) {
            if (sumEqual8(i) && oddDigit(i)){
                System.out.println(i);
            }
        }
    }
}
