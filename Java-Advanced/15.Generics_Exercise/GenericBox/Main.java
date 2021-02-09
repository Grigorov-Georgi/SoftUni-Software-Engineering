package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            System.out.println(box.toString());
        }
    }
}
