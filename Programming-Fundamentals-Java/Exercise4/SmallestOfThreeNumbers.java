import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        smallestNumber(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
    }
    public static void smallestNumber(int a, int b, int c){
        if (a < b && a < c){
            System.out.println(a);
        }else if(b < a && b < c){
            System.out.println(b);
        }else{
            System.out.println(c);
        }
    }
}
