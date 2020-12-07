import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int moment = 0;

        for (int i = 1; i <= number ; i++) { //red
            moment = i;
            for (int j = 0; j < i ; j++) {
                System.out.printf("%d ",moment);
            }
            System.out.println();
        }
    }
}
