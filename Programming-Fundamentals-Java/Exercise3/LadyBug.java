import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] places = new int[n];
        String[] line = (scanner.nextLine()).split(" ");
        for (int i = 0; i < n ; i++) {
            if (line[i].equals("0")){
                places[0] = 1;
            }else if (line[i].equals("1")){
                places[1] = 1;
            }else if (line[i].equals("2")){
                places[2] = 1;
            }
        }
        String line1 = scanner.nextLine();
        while (!line1.equals("end")){
            String[] commands = line1.split(" ");
            int bugIndex = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int length = Integer.parseInt(commands[2]);

            if (bugIndex < 0 || bugIndex >= places.length || places[bugIndex] != 1) {
                line1 = scanner.nextLine();
                continue;
            }

            if (direction.equals("right")){
                while (places[bugIndex + length] < places.length && places[bugIndex + length] != 1) {
                    places[bugIndex+length] = 1;

                }
            }else {
                places[bugIndex] = 0;
                while (places[bugIndex - length] > places.length && places[bugIndex - length] != 1){
                    places[bugIndex - length] = 1;
                }
            }

            line1 = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(places[i] + " ");
        }
    }
}
