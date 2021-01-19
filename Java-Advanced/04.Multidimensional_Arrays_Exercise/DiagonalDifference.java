import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = createMatrix(n, scanner);
        System.out.println(getDiagonalDifference(matrix));
    }

    private static int getDiagonalDifference(int[][] matrix) {
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int difference = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    primaryDiagonal += matrix[i][j];
                }
                if (i + j == matrix.length - 1) {
                    secondaryDiagonal += matrix[i][j];
                }
            }
        }
        difference = Math.abs(primaryDiagonal - secondaryDiagonal);
        return difference;
    }

    private static int[][] createMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
