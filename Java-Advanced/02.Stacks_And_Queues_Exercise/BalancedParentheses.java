import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> firstHalf = new ArrayDeque<>();
        ArrayDeque<String> secondHalf = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("");

        if (input.length % 2 != 0){
            System.out.println("NO");
        }else{
            for (int i = 0; i < input.length / 2 ; i++) {
                firstHalf.push(input[i]);
                secondHalf.push(input[input.length - i - 1]);
            }

            boolean same = true;
            while(!firstHalf.isEmpty()) {
                String firstCurrent = firstHalf.pop();
                String secondCurrent = secondHalf.pop();
                switch (firstCurrent){
                    case "(":
                        if (!secondCurrent.equals(")")){
                            same = false;
                        }
                        break;
                    case "{":
                        if (!secondCurrent.equals("}")){
                            same = false;
                        }
                        break;
                    case "[":
                        if (!secondCurrent.equals("]")){
                            same = false;
                        }
                        break;
                    default:
                        same = false;
                        break;
                }
            }
            if (same){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
