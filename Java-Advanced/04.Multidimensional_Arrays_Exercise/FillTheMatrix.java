import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = makeMatrix(n, pattern);
        printMatrix(matrix);

    }

    private static int[][] makeMatrix(int n, String pattern) {
        int[][] matrix = new int[n][n];
        if (pattern.equals("A")){
            usePatternA(matrix);
        }else if (pattern.equals("B")){
            usePatternB(matrix);
        }
        return matrix;
    }

    private static void usePatternB(int[][] matrix) {
        int number = 1;

        for (int cols = 0; cols < matrix[0].length ; cols++) {
            for (int rows = 0; rows < matrix.length ; rows++) {
                matrix[rows][cols] = number++;
            }
            if (cols + 1 < matrix[0].length) {
                cols++;
                for (int rows = matrix.length - 1; rows >= 0; rows--) {
                    matrix[rows][cols] = number++;
                }
            }
        }
    }

    private static void usePatternA(int[][] matrix) {
        int number = 1;

        for (int cols = 0; cols < matrix[0].length ; cols++) {
            for (int rows = 0; rows < matrix.length ; rows++) {
                matrix[rows][cols] = number++;
            }
        }
    }


    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length ; rows++) {
            for (int cols = 0; cols < matrix[rows].length ; cols++) {
                System.out.print(String.format("%d ", matrix[rows][cols]));
            }
            System.out.println();
        }
    }

}
