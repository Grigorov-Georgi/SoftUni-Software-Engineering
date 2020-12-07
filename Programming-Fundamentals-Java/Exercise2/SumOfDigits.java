import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int lastDigit = 0;
        int sum = 0;
        while (n > 0){
            lastDigit = n % 10;
            n /= 10;
            sum += lastDigit;
        }
        System.out.println(sum);
    }
}
