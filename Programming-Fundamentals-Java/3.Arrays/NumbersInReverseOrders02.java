import java.util.Scanner;

public class NumbersInReverseOrders02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length / 2 ; i++) {
            int swapNumbers = numbers.length - 1 - i;
            int oldNumber = numbers[i];
            numbers[i] = numbers[swapNumbers];
            numbers[swapNumbers] = oldNumber;
        }
        for (int i = 0; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
