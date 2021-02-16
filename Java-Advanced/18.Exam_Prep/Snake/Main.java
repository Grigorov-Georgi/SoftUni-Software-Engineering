package Snake;

import java.util.Scanner;

public class Main {
    static int rowPosition = -1;
    static int colPosition = -1;
    static int eatenFood = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        locateSnake(matrix);


        boolean gameOn = true;
        while (eatenFood < 10 && gameOn) {

            String command = scanner.nextLine();
            switch (command) {
                case "right":
                    gameOn = move(matrix, rowPosition, colPosition + 1);
                    break;
                case "left":
                    gameOn = move(matrix, rowPosition, colPosition - 1);
                    break;
                case "down":
                    gameOn = move(matrix, rowPosition + 1, colPosition);
                    break;
                case "up":
                    gameOn = move(matrix, rowPosition - 1, colPosition);
                    break;
            }
        }

        if (!gameOn) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + eatenFood);

        printMatrix(matrix);
    }

    public static boolean move(char[][] matrix, int newRow, int newCol) {
        if (!isInBounds(matrix, newRow, newCol)) {
            matrix[rowPosition][colPosition] = '.';
            return false;
        }
        char element = matrix[newRow][newCol];
        if (element == '*') {
            eatenFood++;
        } else if (element == 'B') {
            matrix[rowPosition][colPosition] = '.';
            matrix[newRow][newCol] = '.';
            int[] positionOfAnotherBurrow = locateAnotherBurrow(matrix);
            rowPosition = positionOfAnotherBurrow[0];
            colPosition = positionOfAnotherBurrow[1];
            matrix[rowPosition][colPosition] = 'S';
            return true;
        }
        matrix[rowPosition][colPosition] = '.';
        matrix[newRow][newCol] = 'S';
        rowPosition = newRow;
        colPosition = newCol;
        return true;
    }

    public static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    public static int[] locateAnotherBurrow(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    public static void locateSnake(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    rowPosition = i;
                    colPosition = j;
                    return;
                }
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
