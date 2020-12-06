import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%.0f", calculate(Integer.parseInt(scanner.nextLine()), scanner.nextLine(), (Integer.parseInt(scanner.nextLine()))));
    }
    public static double calculate(int a, String operation, int b){
        double result = 0;
        switch (operation){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a * 1.0 / b;
                break;
        }


        return  result;
    }
}
