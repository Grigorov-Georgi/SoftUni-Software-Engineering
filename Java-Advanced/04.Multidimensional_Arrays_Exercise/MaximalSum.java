import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = create(rows, cols, scanner);

        int[][] magicMatrix = findMaximalSumMatrix(matrix);

        printMatrix(magicMatrix);


    }

    private static int[][] findMaximalSumMatrix(int[][] matrix) {
        int[][] rightMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;
        int indexOfMaxSumRow = -1;
        int indexOfMaxSumCol = -1;
        int sum = 0;

        for (int startingRow = 0; startingRow < matrix.length - 2 ; startingRow++) {
            for (int startingCol = 0; startingCol < matrix[0].length - 2; startingCol++) {
                for (int currentRow = startingRow; currentRow < startingRow + 3 ; currentRow++) {
                    for (int currentCol = startingCol; currentCol < startingCol + 3 ; currentCol++) {
                        sum += matrix[currentRow][currentCol];
                    }
                }
                if (sum > maxSum){
                    maxSum = sum;
                    indexOfMaxSumRow = startingRow;
                    indexOfMaxSumCol = startingCol;
                }
                sum = 0;
            }
        }
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                rightMatrix[i][j] = matrix[indexOfMaxSumRow + i][indexOfMaxSumCol + j];
            }
        }
        System.out.println("Sum = " + maxSum);
        return rightMatrix;
    }

    private static void printMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((matrix[i][j] + " "));
            }
            System.out.println();
        }
    }

    private static int[][] create(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows ; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

}
