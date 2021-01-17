import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int col = 0;
        int row = 0;
        for (int i = 0; i < matrix.length - 1 ; i++) {
            for (int j = 0; j < matrix[0].length - 1 ; j++) {
                sum += matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > maxSum){
                    maxSum = sum;
                    col = j;
                    row = i;
                }
                sum = 0;
            }
        }
        System.out.println(matrix[row][col] + " " + matrix[row][col + 1]);
        System.out.println(matrix[row + 1][col] + " " + matrix[row + 1][col + 1]);
        System.out.println(maxSum);
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split(", ");

            for (int j = 0; j < tokens.length; j++) {
                matrix[row][j] = Integer.parseInt(tokens[j]);
            }
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
