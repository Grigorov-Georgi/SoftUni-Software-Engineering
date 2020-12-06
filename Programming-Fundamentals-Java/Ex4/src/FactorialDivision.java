import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        double finalResult = factorialDivision(firstNum) * 1.0 / factorialDivision(secondNum);
        System.out.printf("%.2f", finalResult);
    }

    static long factorialDivision(int a) {
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}

