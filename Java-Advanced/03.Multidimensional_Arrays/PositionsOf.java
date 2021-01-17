import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);
        int neededNumber = Integer.parseInt(scanner.nextLine());

        int firstCoordinate = 0;
        int secondCoordinate = 0;

        boolean numberIsFound = false;

        for (int r = 0; r < matrix.length ; r++) {
            firstCoordinate = r;
            for (int c = 0; c < matrix[r].length ; c++) {
                if (neededNumber == matrix[r][c]){
                    numberIsFound = true;
                    secondCoordinate = c;
                    System.out.println(firstCoordinate + " " + secondCoordinate);
                }
            }
        }
        if (!numberIsFound){
            System.out.println("not found");
        }

    }

    private static int[][] createMatrix(Scanner scanner){
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;

    }

    private static int[] readArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
