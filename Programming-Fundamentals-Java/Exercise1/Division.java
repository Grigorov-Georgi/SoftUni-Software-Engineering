import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        String digit = "";
        if (number % 2 == 0) {
            digit = "The number is divisible by 2";
        }
        if (number % 3 == 0) {
            digit = "The number is divisible by 3";
        }
        if (number % 6 == 0) {
            digit = "The number is divisible by 6";
        }
        if (number % 7 == 0) {
            digit = "The number is divisible by 7";
        }
        if (number % 10 == 0) {
            digit = "The number is divisible by 10";
        }
        if (number % 2 != 0 && number % 3 != 0 && number % 7 != 0) {
            digit = "Not divisible";
        }

        System.out.println(digit);
    }
}

