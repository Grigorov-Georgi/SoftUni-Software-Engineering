import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];


            switch (command) {
                case "1":
                    int pushNumber = Integer.parseInt(tokens[1]);
                    stack.push(pushNumber);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "3":
                    int max = Collections.max(stack);
                    if (stack.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(max);
                    }
                    break;
            }
        }
    }
}
