import java.util.Scanner;

public class AddAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        substract(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
    }
    public static int sum(int a, int b){
        int sum = a + b;
        return sum;
    }
    public static void substract (int a, int b, int c){
        int result = sum(a, b) - c;
        System.out.println(result);

    }
}
