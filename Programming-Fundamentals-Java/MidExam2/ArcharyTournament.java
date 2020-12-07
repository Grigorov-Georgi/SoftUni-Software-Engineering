import java.sql.SQLOutput;
import java.util.Scanner;

public class ArcharyTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\|");
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        int score = 0;

        String input = scanner.nextLine();

        while(!input.equals("Game over")){
            String[] tokens = input.split("@");
            String command = tokens[0];
            int finalIndex = 0;
            switch (command){
                case "Shoot Left":
                    int index1 = Integer.parseInt(tokens[1]);
                    int length1 = Integer.parseInt(tokens[2]);

                    if (index1 > arr.length - 1 || index1 < 0){
                        break;
                    }

                    for (int i = 0; i < length1 ; i++) {
                        index1 -= 1;

                        if (index1 < 0){
                            index1 += arr.length;
                        }
                    }
                    if (arr[index1] > 5){
                        arr[index1] -= 5;
                        score += 5;
                    }else{
                        score += arr[index1];
                        arr[index1] = 0;
                    }


                    break;
                case "Shoot Right":
                    int index2 = Integer.parseInt(tokens[1]);
                    int length2 = Integer.parseInt(tokens[2]);

                    if (index2 > arr.length - 1 || index2 < 0){
                        break;
                    }

                    for (int i = 0; i < length2 ; i++) {
                        index2 += 1;

                        if (index2 > arr.length - 1){
                            index2 -= arr.length;
                        }
                    }
                    if (arr[index2] > 5){
                        arr[index2] -= 5;
                        score += 5;
                    }else{
                        score += arr[index2];
                        arr[index2] = 0;
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < arr.length / 2 ; i++) {
                        int current = arr[i];
                        arr[i] = arr[arr.length - 1 - i];
                        arr[arr.length - 1 - i] = current;

                    }

                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i <arr.length ; i++) {
            array[i] = arr[i] + "";
        }
        System.out.println(String.join(" - ", array));
        System.out.printf("Iskren finished the archery tournament with %d points!", score);
    }
}
