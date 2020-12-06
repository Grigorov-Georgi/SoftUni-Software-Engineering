import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] wagon = new int[n];
        for (int i = 0; i < wagon.length ; i++) {
            wagon[i] = Integer.parseInt(scanner.nextLine());
        }
        int sum = 0;
        String wagons = "";
        for (int i = 0; i < wagon.length ; i++) {
            wagons += wagon[i] + " ";
            sum+=wagon[i];
        }
        System.out.println(wagons);
        System.out.println(sum);
    }
}
