import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = createMatrix(rows, cols, scanner);
        char[][] secondmatrix = createMatrix(rows, cols, scanner);

        printMatrix(matrixAB(rows, cols, firstMatrix, secondmatrix));
    }

    private static char[][] matrixAB(int rows, int cols, char[][] firstMatrix, char[][] secondMatrix) {
        char[][] matrixAB = new char[rows][cols];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    matrixAB[i][j] = firstMatrix[i][j];
                } else {
                    matrixAB[i][j] = '*';
                }
            }

        }
        return matrixAB;
    }


    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] createMatrix(int rows, int cols, Scanner scanner) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i++) {
                matrix[row][i] = tokens[i].charAt(0);
            }
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
