import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String all = "";
        for (int i = 0; i <3 ; i++) {
            char a = scanner.nextLine().charAt(0);
            all+=a;
        }

        System.out.println(all);
    }
}
