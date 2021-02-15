package Bee;

import java.util.Scanner;

public class Main {

    static int rowPosition = 0;
    static int colPosition = 0;
    static int flowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        locateBee(matrix);

        boolean inBounds = true;

        String command;
        while (!("End").equals(command = scanner.nextLine())) {
            switch (command) {
                case "right":
                    inBounds = move(matrix, rowPosition, colPosition + 1, "right");
                    break;
                case "left":
                    inBounds = move(matrix, rowPosition, colPosition - 1, "left");
                    break;
                case "down":
                    inBounds = move(matrix, rowPosition + 1, colPosition, "down");
                    break;
                case "up":
                    inBounds = move(matrix, rowPosition - 1, colPosition, "up");
                    break;
            }
            if (!inBounds){
                break;
            }
        }

        if (!inBounds){
            System.out.println("The bee got lost!");
        }

        if (flowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        printMatrix(matrix);


    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void locateBee(char[][] matrix) {
        boolean isFounded = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    rowPosition = i;
                    colPosition = j;
                    isFounded = true;
                    break;
                }
            }
            if (isFounded) {
                break;
            }
        }
    }

    //right -> row, col + 1
    public static boolean move(char[][] matrix, int newRow, int newCol, String direction) {
        if (isInBounds(matrix, newRow, newCol)) {
            char elementOnNewPosition = matrix[newRow][newCol];
            if (elementOnNewPosition == 'f') {
                flowers++;
            } else if (elementOnNewPosition == 'O'){
                matrix[newRow][newCol] = '.';
                switch (direction){
                    case "right":
                        newCol++;
                        break;
                    case "left":
                        newCol--;
                        break;
                    case "down":
                        newRow++;
                        break;
                    case "up":
                        newRow--;
                        break;
                }
                move(matrix, newRow, newCol, direction);
            }
            matrix[rowPosition][colPosition] = '.';
            matrix[newRow][newCol] = 'B';
            rowPosition = newRow;
            colPosition = newCol;
        } else {
            matrix[rowPosition][colPosition] = '.';
            return false;
        }
        return true;
    }

    public static boolean isInBounds(char[][] matrix, int newRow, int newCol) {
        return newRow >= 0 && newRow < matrix.length
                && newCol >= 0 && newCol < matrix[0].length;
    }


}
