import java.util.Scanner;

public class BackIn30Mins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int allMinutes = hour * 60 + minutes + 30;
        if (allMinutes >= 24*60){
            allMinutes -= 24*60;
        }
        System.out.printf("%d:%02d", allMinutes / 60, allMinutes % 60);
    }
}
