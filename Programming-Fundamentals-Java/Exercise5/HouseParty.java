import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = new ArrayList<>();

        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands ; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            if (!names.contains(tokens[0]) && tokens[2].equals("going!")){
                names.add(tokens[0]);
            }else if (!names.contains(tokens[0]) && tokens[2].equals("not")){
                System.out.println(tokens[0] + " is not in the list!");
            }else if (names.contains(tokens[0]) && tokens[2].equals("not")){
                names.remove(tokens[0]);
            }else  if (names.contains(tokens[0]) && tokens[2].equals("going!")){
                System.out.println(tokens[0] + " is already in the list!");
            }
        }
        for (int i = 0; i < names.size() ; i++) {
            System.out.println(names.get(i));
        }
    }
}
