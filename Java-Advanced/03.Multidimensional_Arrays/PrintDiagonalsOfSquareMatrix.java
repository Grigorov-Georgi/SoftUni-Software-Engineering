import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
//        int[][] matrix = createMatrix(scanner, n);
        int[][] matrix1 = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix1[i] = readArray(scanner);
        }
        int row = 0, col = 0;
        while (row < n && col < n) {
            System.out.print(matrix1[row++][col++] + " ");
        }
        System.out.println();
        row = n - 1;
        col = 0;
        while (row >= 0 && col < n) {
            System.out.print(matrix1[row--][col++] + " ");
        }
//        getDiagonals(matrix);

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

//    private static void getDiagonals(int[][] matrix) {
//        String firstDiagonal = "";
//        String secondDiagonal = "";
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (i == j) {
//                    firstDiagonal += matrix[i][j] + " ";
//                }
//            }
//        }
//        for (int i = matrix.length - 1; i >= 0 ; i--) {
//            for (int j = 0; j < matrix[0].length ; j++) {
//                if (i + j == matrix.length - 1){
//                    secondDiagonal += matrix[i][j] + " ";
//                }
//            }
//        }
//        System.out.println(firstDiagonal);
//        System.out.println(secondDiagonal);
//    }

//    private static int[][] createMatrix(Scanner scanner, int rows) {
//        int[][] matrix = new int[rows][rows];
//
//        for (int i = 0; i < rows; i++) {
//            String[] tokens = scanner.nextLine().split("\\s+");
//            for (int j = 0; j < rows; j++) {
//                matrix[i][j] = Integer.parseInt(tokens[j]);
//            }
//        }
//        return matrix;
//    }
}
