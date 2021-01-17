import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner, ", ");
        printSumOfMatrix(matrix);
    }

    private static void printSumOfMatrix(int[][] matrix){
        int sum = 0;
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int[] ints : matrix) {
            for (int number : ints) {
                sum += number;
            }
        }
        System.out.println(sum);
    }

    private static int[][] createMatrix(Scanner scanner, String pattern){
        int[] dimensions = readArray(scanner, pattern);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows ; row++) {
            String[] tokens = scanner.nextLine().split(pattern);

            for (int i = 0; i < tokens.length ; i++) {
                matrix[row][i] = Integer.parseInt(tokens[i]);
            }
        }
        return matrix;
    }
    private static int[] readArray(Scanner scanner, String pattern){

        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(value -> Integer.parseInt(value)).toArray();
    }
}
