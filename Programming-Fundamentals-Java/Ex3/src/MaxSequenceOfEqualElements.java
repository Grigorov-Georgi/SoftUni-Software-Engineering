import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int sequence = 1;
        int firstSequence = 0;
        int firstNumber = 0;
        int currentNumber = 0;
        boolean firstNumberFound = false;
        int biggestSequence = 1;
        int numberByBiggestSequence = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sequence > biggestSequence) {
                biggestSequence = sequence;
                numberByBiggestSequence = currentNumber;
            }

            sequence = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    sequence++;
                } else {
                    break;
                }
            }
            if (!firstNumberFound && sequence > 1) {
                firstNumber = arr[i];
                firstSequence = sequence;
                sequence = 1;
                firstNumberFound = true;
            }
            currentNumber = arr[i];
        }
        if (firstSequence >= biggestSequence) {
            for (int i = 0; i < firstSequence; i++) {
                System.out.print(firstNumber + " ");
            }
        } else {
            for (int i = 0; i < biggestSequence; i++) {
                System.out.print(numberByBiggestSequence + " ");
            }
        }
    }
}

