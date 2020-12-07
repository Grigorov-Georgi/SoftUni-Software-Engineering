import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        switch (operation){
            case "divide":
                divideOperation(firstNumber, secondNumber);
                break;
            case "substract":
                substractOperation(firstNumber, secondNumber);
                break;
            case "multiply":
                multiplyOperation(firstNumber, secondNumber);
                break;
            case "add":
                addOperation(firstNumber, secondNumber);
                break;
        }

    }
    static void divideOperation(int first, int second){
        System.out.println(first / second);
    }
    static void addOperation(int first, int second){
        System.out.println(first + second);
    }
    static void substractOperation(int first, int second){
        System.out.println(first - second);
    }
    static void multiplyOperation(int first, int second){
        System.out.println(first * second);
    }
}
