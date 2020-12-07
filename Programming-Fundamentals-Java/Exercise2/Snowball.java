import java.util.Scanner;

public class Snowball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double bestValue = 0;
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;
        for (int i = 0; i < n ; i++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow((snowBallSnow / snowballTime), snowballQuality);
            if (snowballValue > bestValue){
                bestValue = snowballValue;
                bestSnow = snowBallSnow;
                bestQuality = snowballQuality;
                bestTime = snowballTime;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestTime, bestValue, bestQuality);

    }
}
