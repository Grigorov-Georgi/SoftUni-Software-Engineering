import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        String lastNumber = "";
        String firstNumber = "";

        for (int i = 0; i < n ; i++) {
            firstNumber = arr[0];

            for (int j = 1; j < arr.length ; j++) {
                String newNumber = arr[j];
                arr[j-1] = newNumber;
            }
            arr[arr.length - 1] = firstNumber;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
