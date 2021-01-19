import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = createMatrix(rows, cols, scanner);

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] inputAsArray = input.split("\\s+");
            String command = inputAsArray[0];

            boolean isValid = true;

            if (inputAsArray.length != 5 ){
                isValid = false;
            }else {
                if (!command.equals("swap")){
                    isValid = false;
                }else {
                    int row1 = Integer.parseInt(inputAsArray[1]);
                    int col1 = Integer.parseInt(inputAsArray[2]);
                    int row2 = Integer.parseInt(inputAsArray[3]);
                    int col2 = Integer.parseInt(inputAsArray[4]);

                    if (row1 > matrix.length || row2 > matrix.length || col1 > matrix.length || col2 > matrix.length){
                        isValid = false;
                    }else{
                        String currentText = matrix[row1][col1];

                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = currentText;
                        printMatrix(matrix);
                    }
                }
            }
            if (!isValid){
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    private static void printMatrix (String[][] matrix){
        for (String[] text : matrix) {
            for (String s : text) {
                System.out.printf("%s ", s);
            }
            System.out.println();
        }
    }

    private static String[][] createMatrix(int rows, int cols, Scanner scanner){
        String[][] matrix = new String[rows][cols];


        for (int row = 0; row < rows ; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[row] = input;
        }
        return matrix;
    }

}
