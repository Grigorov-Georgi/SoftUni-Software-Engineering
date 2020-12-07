import java.util.Scanner;

public class Passed {
    public static void main(String[] args) {
        double grade = new Scanner(System.in).nextDouble();
        if (grade >= 3){
            System.out.print("Passed!");
        }else {
            System.out.println("Failed!");
        }
    }
}
