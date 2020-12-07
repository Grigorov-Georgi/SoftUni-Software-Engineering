import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        declaringNumber();
    }

    public static void declaringNumber(){
        Scanner scanner = new Scanner(System.in);
        int digit = Integer.parseInt(scanner.nextLine());
        if (digit < 0){
            System.out.printf("The number %d is negative.", digit);
        }else if (digit > 0){
            System.out.printf("The number %d is positive.", digit);
        }else{
            System.out.println("The number 0 is zero.");
        }
    }
}
