import java.util.Scanner;

public class ReadArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = readArray(scanner);
        printArray(firstArray);
    }
    public static int[] readArray(Scanner scanner){
        String[] line = scanner.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i <line.length ; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }
    public static void printArray(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
