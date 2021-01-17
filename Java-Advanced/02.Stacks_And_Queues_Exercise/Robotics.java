import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsNamesAndTime = (scanner.nextLine().split(";"));
        String[] names = new String[robotsNamesAndTime.length];
        int[] processTime = new int[robotsNamesAndTime.length];

        for (int i = 0; i < robotsNamesAndTime.length; i++) {
            String[] tokens = robotsNamesAndTime[i].split("-");
            String name = tokens[0];
            int time = Integer.parseInt(tokens[1]);

            names[i] = name;
            processTime[i] = time;
        }

        String[] givenTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(givenTime[0]);
        int minutes = Integer.parseInt(givenTime[1]);
        int seconds = Integer.parseInt(givenTime[2]);

        long timeInSec = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            productsQueue.offer(input);
            input = scanner.nextLine();
        }

        int[] isFree = new int[robotsNamesAndTime.length];
        int[] workedTime = new int[robotsNamesAndTime.length];

        int[] robotsWorkLeft = new int[robotsNamesAndTime.length];


        while (!productsQueue.isEmpty()) {
            timeInSec++;
            String product = productsQueue.poll();
            int index = -1;

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    robotsWorkLeft[i]--;
                }
                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotsWorkLeft[index] = processTime[index];
                System.out.println(printRobotData(names[index], product, timeInSec));
            } else {
                productsQueue.offer(product);
            }

        }

    }

    public static String printRobotData(String name, String product, long time) {
        String result = String.format("%s - %s [%s]", name, product, getTime(time));
        return result;
    }

    public static String getTime(long timeInSeconds) {
        long seconds = timeInSeconds % 60;
        long minutes = (timeInSeconds/ 60) % 60;
        long hours =  (timeInSeconds / (60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
