import java.util.Scanner;

public class UpperLower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);
        if (a >= 65 && a <= 90){
            System.out.println("upper-case");
        }else if (a >= 'a' && a <= 'z'){
            System.out.println("lower-case");
        }
    }
}
