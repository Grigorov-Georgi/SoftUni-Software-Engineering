import java.util.Scanner;

public class ReformStronNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        boolean isSpecialNum = false;
        for (int i = 1; i <= n; i++) {
            int number = i;
            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
            isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            System.out.printf("%d -> ", i);
            if (isSpecialNum){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
            sum = 0;
            isSpecialNum = false;
        }

    }
}
