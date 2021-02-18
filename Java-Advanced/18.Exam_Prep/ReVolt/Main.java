package ReVolt;

import java.util.Scanner;

public class Main {

    static int rowPosition = -1;
    static int colPosition = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length ; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        //locate player
        int[] locatePlayer = locate('f', matrix);
        rowPosition = locatePlayer[0];
        colPosition = locatePlayer[1];

        boolean gameOn = true;
        while (m-- > 0){
            String command = scanner.nextLine();

            switch (command){
                case "right":
                    gameOn = move(matrix, rowPosition, colPosition + 1, "right");
                    break;
                case "left":
                    gameOn = move(matrix, rowPosition, colPosition - 1, "left");
                    break;
                case "down":
                    gameOn = move(matrix, rowPosition + 1, colPosition, "down");
                    break;
                case "up":
                    gameOn = move(matrix, rowPosition - 1, colPosition, "up");
                    break;
            }
            if (!gameOn){
                break;
            }

        }

        if (!gameOn){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }

        pritnMatrix(matrix);
    }

    public static boolean move(char[][] matrix, int newRow, int newCol, String direction) {
        matrix[rowPosition][colPosition] = '-';
        if (!inBounds(matrix, newRow, newCol)){
            switch (direction){
                case "right":
                    newCol = 0;
                    break;
                case "left":
                    newCol = matrix.length - 1;
                    break;
                case "down":
                    newRow = 0;
                    break;
                case "up":
                    newRow = matrix.length - 1;
                    break;
            }
        }
        if (matrix[newRow][newCol] == 'B'){
            if (newRow == 0 || newCol == 0) {

            }
            switch (direction){
                case "right":
                    if (newCol == matrix.length - 1){
                     newCol = 0;
                    }else {
                        newCol++;
                    }
                    break;
                case "left":
                    if (newCol == 0){
                        newCol = matrix.length - 1;
                    }else {
                        newCol--;
                    }
                    break;
                case "down":
                    if (newRow == matrix.length - 1){
                        newRow = 0;
                    }else {
                        newRow++;
                    }
                    break;
                case "up":
                    if (newRow == 0){
                        newRow = matrix.length - 1;
                    }else {
                        newRow--;
                    }
                    break;
            }
        }else if (matrix[newRow][newCol] == 'T'){
            switch (direction){
                case "right":
                    newCol--;
                    break;
                case "left":
                    newCol++;
                    break;
                case "down":
                    newRow--;
                    break;
                case "up":
                    newRow++;
                    break;
            }
        }else if (matrix[newRow][newCol] == 'F'){
            matrix[newRow][newCol] = 'f';
            return false;
        }
        matrix[newRow][newCol] = 'f';
        rowPosition = newRow;
        colPosition = newCol;
        return true;
    }

    public static boolean inBounds(char[][] matrix, int row, int col){
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    public static int[] locate(char character, char[][] matrix){
        int[] rowAndCol = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == character){
                    rowAndCol[0] = i;
                    rowAndCol[1] = j;
                }
            }
        }
        return rowAndCol;
    }

    public static void pritnMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
