import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        grade(Double.parseDouble(scanner.nextLine()));
    }
    public static void grade(double digit){
        if (digit < 3){
            System.out.println("Fail");
        }else if(digit < 3.5){
            System.out.println("Poor");
        }else if(digit < 4.5){
            System.out.println("Good");
        }else if(digit < 5.5){
            System.out.println("Very good");
        }else{
            System.out.println("Excellent");
        }
    }
}
