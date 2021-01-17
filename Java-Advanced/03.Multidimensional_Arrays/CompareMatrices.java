import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = createMatrix(scanner);
        int[][] secondMatrix = createMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {

            for (int row = 0; row < firstMatrix.length; row++) {

                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];

                areNotEqual = firstArr.length != secondArr.length;

                if (!areNotEqual){
                    for (int col = 0; col < firstArr.length ; col++) {
                        if (firstArr[col] != secondArr[col]){
                             areNotEqual = true;
                             break;
                        }
                    }
                }
                if (areNotEqual){
                    break;
                }
            }
        }
        String output = areNotEqual ? "not equal" : "equal";

        System.out.println(output);
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = readArray(scanner);
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
