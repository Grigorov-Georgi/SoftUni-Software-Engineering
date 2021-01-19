import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = getPalindrome(i, j);
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
    private static String getPalindrome(int row, int col){
        String palindrome = ((char) (97 + row)) + "" + ((char) (97 + row + col)) + ((char) (97 + row));
        return palindrome;
    }
}
