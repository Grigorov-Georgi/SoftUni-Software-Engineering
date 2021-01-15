import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int smallest = Integer.MAX_VALUE;

        String[] number = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numberStack.push(Integer.parseInt(number[i]));
        }

        for (int i = 0; i < s; i++) {
            numberStack.pop();
        }

        for (int i = 0; i < numberStack.size(); i++) {
            if (Integer.parseInt(number[i]) < smallest) {
                smallest = Integer.parseInt(number[i]);
            }
        }

        if (numberStack.contains(x)) {
            System.out.println("true");
        }else if (numberStack.isEmpty()) {
            System.out.println("0");
        }else{
            System.out.println(smallest);
        }
    }
}
