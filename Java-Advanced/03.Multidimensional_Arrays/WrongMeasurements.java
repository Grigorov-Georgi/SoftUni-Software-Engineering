import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < n ; i++) {
            matrix[i] = readArray(scanner);
        }
        int[] coordinates = readArray(scanner);
        int coordinatesRow = coordinates[0];
        int coordinatesCol = coordinates[1];
        int wrongNumber = matrix[coordinatesRow][coordinatesCol];

        ArrayList<int[]> rightInfo = new ArrayList<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == wrongNumber){
                    int rightValue = calculateRightValue(i, j, wrongNumber, matrix);
                    rightInfo.add(new int[]{i, j, rightValue});
                }
            }
        }
        for (int[] info : rightInfo) {
            matrix[info[0]][info[1]] = info[2];
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }



    private static int calculateRightValue(int row, int col, int wrongNumber, int[][] matrix){
        int rightValue = 0;
        if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongNumber ){
            rightValue += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongNumber ){
            rightValue += matrix[row + 1][col];
        }
        if (isInBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongNumber ){
            rightValue += matrix[row][col - 1];
        }
        if (isInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongNumber ){
            rightValue += matrix[row][col + 1];
        }
        return rightValue;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0;
    }

    private static int[] readArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
