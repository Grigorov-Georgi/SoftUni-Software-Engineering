import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        int[] number = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            number[i] = Integer.parseInt(arr[i]);
        }
        boolean isBigger = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (number[i] <= number[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.print(number[i] + " ");
            }
            isBigger = true;
        }
    }
}
