import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] array = line1.split(" ");
        int[] number = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            number[i] = Integer.parseInt(array[i]);
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputArray = input.split(" ");
            String command = inputArray[0];
            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(inputArray[1]);
                    if (index >= 0 && index < number.length) {
                        exchangeArray(number, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "min":
                    if (inputArray[1].equals("odd")) {
                        System.out.println(findMinOdd(number));
                    } else {
                        System.out.println(findMinEven(number));
                    }

                    break;
                case "max":
                    if (inputArray[1].equals("odd")) {
                        System.out.println(findMaxOdd(number));
                    } else {
                        System.out.println(findMaxEven(number));
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(inputArray[1]);
                    if (countFirst > number.length) {
                        System.out.println("Invalid count");
                    } else if (inputArray[2].equals("odd")) {

                    } else {

                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(inputArray[1]);
                    if (countLast > number.length) {
                        System.out.println("Invalid count");
                    } else if (inputArray[2].equals("odd")) {

                    } else {

                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(number));
    }

    private static void exchangeArray(int[] arr, int index) {
        int[] first = new int[index + 1];
        int[] second = new int[arr.length - (index + 1)];
        for (int i = 0; i <= index; i++) {
            first[i] = arr[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            second[i - (index + 1)] = arr[i];
        }
        for (int i = 0; i < second.length; i++) {
            arr[i] = second[i];
        }
        for (int i = 0; i < first.length; i++) {
            arr[i + second.length] = first[i];
        }
    }

    private static int findMaxOdd(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] >= maxElement) {
                maxElement = arr[i];
                index = i;
            }
        }
        return index;
    }
    private static int findMaxEven(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= maxElement) {
                maxElement = arr[i];
                index = i;
            }
        }
        return index;
    }
    private static int findMinOdd(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= minElement) {
                minElement = arr[i];
                index = i;
            }
        }
        return index;
    }
    private static int findMinEven(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= minElement) {
                minElement = arr[i];
                index = i;
            }
        }
        return index;
    }
}
