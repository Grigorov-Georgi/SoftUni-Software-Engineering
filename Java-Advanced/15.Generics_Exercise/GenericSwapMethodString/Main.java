package GenericSwapMethodString;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        while(n-- > 0){
            int input = Integer.parseInt(scanner.nextLine());
            box.addValue(input);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(indexes[0], indexes[1]);
        System.out.println(box.toString());
    }
}
