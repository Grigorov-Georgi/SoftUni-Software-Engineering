import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Math.abs(Integer.parseInt(scanner.nextLine()));
        while(n % 2 == 1){
            System.out.println("Please write an even number.");
            n = Math.abs(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("The number is: " + n);
    }
}
