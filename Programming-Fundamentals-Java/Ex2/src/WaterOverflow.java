import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        final int capacity = 255;

        int sumOfLiters = 0;
        for (int i = 0; i < n; i++) {
            int litters = Integer.parseInt(scanner.nextLine());
            sumOfLiters +=litters;
            if (sumOfLiters > capacity){
                System.out.println("Insufficient capacity!");
                sumOfLiters -= litters;
            }
        }
        System.out.println(sumOfLiters);
    }
}
