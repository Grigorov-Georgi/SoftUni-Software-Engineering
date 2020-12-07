import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class abc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String finale = "";
        String[] input = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                sb.append(input[i]);
            }
        }
        System.out.println(sb.toString());
//        for (int i = 0; i < input.length ; i++) {
//            for (int j = 0; j < input[i].length() ; j++) {
//                finale = finale.concat(input[i]);
//            }
//        }
//        System.out.println(finale);
    }
}
