import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] blocks = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (int i = 0; i < blocks.length; i++) {
            sum += operation(blocks[i]);
        }
        System.out.printf("%.2f", sum);

    }

    private static double operation(String block) {
        char firstLetter = block.charAt(0);
        double number = Double.parseDouble(block.substring(1, block.length() - 1));
        char lastLetter = block.charAt(block.length() - 1);
        if (Character.isUpperCase(firstLetter)) {
            double firstPlace = (double) (firstLetter - 64);
            number /= firstPlace;
        } else {
            double firstPlace = (double) (firstLetter - 96);
            number *= firstPlace;
        }
        if (Character.isUpperCase(lastLetter)) {
            double firstPlace = (double) (lastLetter - 64);
            number -= firstPlace;
        } else {
            double firstPlace = (double) (lastLetter - 96);
            number += firstPlace;
        }
        return number;
    }
}
