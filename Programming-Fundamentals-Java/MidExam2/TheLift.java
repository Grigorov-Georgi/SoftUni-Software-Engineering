import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());

        String[] array = scanner.nextLine().split("\\s+");
        int[] fullSeats = new int[array.length];
        int allPeople = peopleWaiting;
        for (int i = 0; i < array.length ; i++) {
            fullSeats[i] = Integer.parseInt(array[i]);
            allPeople += fullSeats[i];
        }


        int  freeSeats = 0;
        boolean emptySpots = false;

        for (int i = 0; i < array.length ; i++) {
            if (fullSeats[i] < 4){

                freeSeats = 4 - fullSeats[i];
                if (peopleWaiting >= freeSeats){
                    peopleWaiting -= freeSeats;
                    fullSeats[i] = 4;
                }else if (freeSeats > peopleWaiting){
                    fullSeats[i] += peopleWaiting;
                    peopleWaiting = 0;
                }
                if (peopleWaiting == 0){
                    emptySpots = true;
                    break;
                }
            }
        }


        String result = Arrays.stream(fullSeats)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        if ((double) allPeople / 4 == (double) fullSeats.length){
            System.out.println(result);
            return;
        }
        if (emptySpots){
            System.out.println("The lift has empty spots!");
        } else if (!emptySpots && peopleWaiting != 0){
            System.out.println("There isn't enough space! " + peopleWaiting + " people in a queue!");
        }

        System.out.println(result);
    }
}
