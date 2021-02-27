package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);
        fillMatrix(matrix);
        System.out.println(sumPoints(matrix, scanner));

    }
    private static int[][] createMatrix(Scanner scanner){
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] createdMatrix = new int[rows][cols];
        return createdMatrix;
    }

    private static long sumPoints(int[][] matrix, Scanner scanner) {
        long sum = 0;
        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] playersPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilPosition[0] - 1;
            int evilCol = evilPosition[1] - 1;

            while (isInBounds(matrix, evilRow, evilCol)) {
                matrix[evilRow][evilCol] = 0;
                evilRow--;
                evilCol--;
            }

            int playerRow = playersPosition[0] - 1;
            int playerCol = playersPosition[1] + 1;

            while (isInBounds(matrix, playerRow, playerCol)) {
                sum += matrix[playerRow][playerCol];
                playerCol++;
                playerRow--;
            }

            command = scanner.nextLine();
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int newRow, int newCol) {
        return newRow >= 0 && newRow < matrix.length
                && newCol >= 0 && newCol < matrix[newRow].length;
    }

    private static void fillMatrix(int[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
