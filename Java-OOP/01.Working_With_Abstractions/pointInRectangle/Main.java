package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Rectangle rectangle = new Rectangle(array);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int[] point = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(rectangle.contains(point));
        }
    }
}
