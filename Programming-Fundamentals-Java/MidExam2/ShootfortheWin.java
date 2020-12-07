import java.util.Scanner;

public class ShootfortheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");
        int[] targets = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            targets[i] = Integer.parseInt(arr[i]);
        }
        int counter = 0;
        String input = scanner.nextLine();
        while (!input.equals("End")){
            int index = Integer.parseInt(input);
            if (index > targets.length - 1){
                input = scanner.nextLine();
                continue;
            }else{
                counter++;
                int currentTarget = targets[index];

                for (int i = 0; i < targets.length ; i++) {
                    if (i == index){
                        targets[index] = -1;
                    }else{
                        if (targets[i] == -1){
                            continue;
                        }
                        if (targets[i] > currentTarget){
                            targets[i] -= currentTarget;
                        }else{
                            targets[i] += currentTarget;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        String line = "";
        for (int i = 0; i <targets.length ; i++) {
            line += targets[i] + " ";
        }
        System.out.println("Shot targets: " + counter + " -> " + line);
    }
}
