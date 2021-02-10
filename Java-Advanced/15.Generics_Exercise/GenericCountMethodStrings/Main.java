package GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        while(n-- > 0){
            double input = Double.parseDouble(scanner.nextLine());
            box.addValue(input);
        }
        double secondInput = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterElements(secondInput));
    }
}
