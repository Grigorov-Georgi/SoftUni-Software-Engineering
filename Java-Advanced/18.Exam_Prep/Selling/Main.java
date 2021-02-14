package Selling;

import java.util.Scanner;

public class Main {

    static int startRow = 0;
    static int startCol = 0;
    static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf('S');
            }
        }


        boolean isWithinBakery = true;

        while (money < 50 && isWithinBakery) {
            String command = scanner.nextLine();
            switch (command) {
                case "right":
                    isWithinBakery = move(startRow, startCol + 1, matrix);
                    break;
                case "left":
                    isWithinBakery = move(startRow, startCol - 1, matrix);
                    break;
                case "up":
                    isWithinBakery = move(startRow - 1, startCol, matrix);
                    break;
                case "down":
                    isWithinBakery = move(startRow + 1, startCol, matrix);
                    break;
            }
        }

        String message = !isWithinBakery
                ? "Bad news, you are out of the bakery."
                : "Good news! You succeeded in collecting enough money!";

        System.out.println(message);
        System.out.println("Money: " + money);
        printMatrix(matrix);
    }

    private static boolean move( int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';

        if (isOutOfBounds(newRow, newCol, matrix)){
            return false;
        }

        char symbol = matrix[newRow][newCol];

        if (Character.isDigit(symbol)){
            money += symbol - '0';
        } else if (symbol == 'O'){
            int[] rowAndCol = nextPillarsIndexes(newRow, newCol, matrix);
            newRow = rowAndCol[0];
            newCol = rowAndCol[1];
        }
        matrix[newRow][newCol] = 'S';

        startRow = newRow;
        startCol = newCol;
        return true;
    }

    private static int[] nextPillarsIndexes(int row, int col, char[][] martix){
        int[] rowAndColOfNextPillar = new int[2];
        for (int i = 0; i < martix.length ; i++) {
            for (int j = 0; j < martix[i].length ; j++) {
                if (martix[i][j] == 'O' && i != row && j != col){
                    rowAndColOfNextPillar[0] = i;
                    rowAndColOfNextPillar[1] = j;
                }
            }
        }
        martix[row][col] = '-';
        return rowAndColOfNextPillar;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0
                || col >= matrix[row].length || col < 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
