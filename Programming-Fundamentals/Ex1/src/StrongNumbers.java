import java.util.Scanner;

public class StrongNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int originalNumber = number;
        int digit = 0;
        int sum = 1;
        int total = 0;
        while(number != 0){
            digit = number % 10;
            for (int i = 1; i <= digit ; i++) {
                sum *= i;
            }
            total += sum;
            number /= 10;
            sum = 1;

        }
        if (originalNumber == total){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
