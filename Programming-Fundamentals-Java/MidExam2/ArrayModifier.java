import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s+");
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("end")) {


            switch (command[0]) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    int currentNumberAtIndex1 = arr[index1];
                    arr[index1] = arr[index2];
                    arr[index2] = currentNumberAtIndex1;
                    break;
                case "multiply":
                    int index3 = Integer.parseInt(command[1]);
                    int index4 = Integer.parseInt(command[2]);
                    arr[index3] *= arr[index4];
                    break;
                case "decrease":
                    for (int i = 0; i < arr.length ; i++) {
                        arr[i] -= 1;
                    }
                    break;
            }

            command = scanner.nextLine().split("\\s+");
        }
        for (int i = 0; i < array.length ; i++) {
            array[i] = String.valueOf(arr[i]);
        }

        String line = String.join(", ", array);
        System.out.println(line);

    }
}
