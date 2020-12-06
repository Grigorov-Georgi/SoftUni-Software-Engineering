import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sum(Integer.parseInt(scanner.nextLine())));
    }
    static int sum(int number){
        int sumEven = 0;
        int sumOdd = 0;
        int firstNumber = 0;
        number = Math.abs(number);
        while(number > 0){
            firstNumber = number % 10;
            if (firstNumber % 2 == 0){
                sumEven += firstNumber;
            }else {
                sumOdd += firstNumber;
            }
            number /= 10;
        }
        int result = sumEven * sumOdd;
        return result;
    }
}
