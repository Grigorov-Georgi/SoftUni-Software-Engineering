import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int lastDigit = 0;
        int sumOfDigits = 0;
        for (int i = 1; i <= n ; i++) {
            while(true) {
                if (i < 10){
                    sumOfDigits = i;
                    if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                        System.out.printf("%d -> True%n", i);
                        break;
                    } else {
                        System.out.printf("%d -> False%n", i);
                        break;
                    }
                }else {

                    lastDigit = n % 10;
                    if (lastDigit / 10 == 0) {
                        break;
                    }
                    sumOfDigits += lastDigit;
                    if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                        System.out.printf("%d -> True%n", i);
                    } else {
                        System.out.printf("%d -> False%n", i);
                    }
                }
            }
        }
    }
}
