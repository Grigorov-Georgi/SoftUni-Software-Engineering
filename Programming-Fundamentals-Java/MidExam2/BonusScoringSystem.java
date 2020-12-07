import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        List<Integer> attendances = new ArrayList<>();
        int maxAttendance = 0;
        for (int i = 0; i < students ; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            if (attendance > maxAttendance){
                maxAttendance = attendance;
            }
        }

        double totalBonus = (maxAttendance / (double) lectures) * (5 + additionalBonus);
        System.out.println("Max Bonus: " + (int) Math.floor(totalBonus + 0.5) + ".");
        System.out.println("The student has attended " + maxAttendance +" lectures.");
    }
}
