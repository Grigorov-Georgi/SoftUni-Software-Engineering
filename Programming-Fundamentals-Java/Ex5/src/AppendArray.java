import java.util.Scanner;

public class AppendArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\|");

        for (int i = array.length - 1; i >= 0 ; i--) {
            String[] currentArray = array[i].split("\\s+");
            for (int j = 0; j < currentArray.length ; j++) {
                if (!currentArray[j].equals("")) {
                    System.out.print(currentArray[j] + " ");

                }
            }
        }
    }
}
