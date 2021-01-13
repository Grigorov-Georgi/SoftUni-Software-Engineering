import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input= scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int rightOperand = 0;
        int leftOperand = 0;

        for (int i = 0; i < input.length ; i++) {
            if (i == 0){
                numbers.push(Integer.parseInt(input[i]));
                continue;
            }
            rightOperand = Integer.parseInt(input[i + 1]);
            leftOperand = numbers.peek();
            if (input[i].equals("+")){
                numbers.push(leftOperand + rightOperand);
            }else if (input[i].equals("-")){
                numbers.push(leftOperand - rightOperand);
            }
            i++;
        }
        System.out.println(numbers.peek());
    }
}
