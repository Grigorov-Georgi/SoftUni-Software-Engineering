import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("@");
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        String input = scanner.nextLine();
        int currentPosition = 0;
        int counter = 0;
        while (!input.equals("Love!")) {
            String[] tokens = input.split(" ");
            int size = Integer.parseInt(tokens[1]);
            if (currentPosition + size <= (array.length - 1)) {
                currentPosition += size;
                if (array[currentPosition] - 2 == 0) {
                    System.out.println("Place " + currentPosition + " has Valentine's day.");
                    array[currentPosition] -= 2;
                } else if (array[currentPosition] == 0) {
                    System.out.println("Place " + currentPosition + " already had Valentine's day.");
                } else {
                    array[currentPosition] -= 2;
                }
            } else if (currentPosition + size > (array.length - 1)) {
                currentPosition = 0;
                if (array[currentPosition] - 2 == 0) {
                    System.out.println("Place " + currentPosition + " has Valentine's day.");
                    array[currentPosition] -= 2;
                } else if (array[currentPosition] == 0) {
                    System.out.println("Place " + currentPosition + " already had Valentine's day.");
                } else {
                    array[currentPosition] -= 2;
                }

            }


            input = scanner.nextLine();
        }
        System.out.println("Cupid's last position was " + currentPosition + ".");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.println("Cupid has failed " + counter + " places.");
        }
    }
}
