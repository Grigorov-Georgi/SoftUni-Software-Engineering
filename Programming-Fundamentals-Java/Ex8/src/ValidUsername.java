import java.io.CharArrayWriter;
import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(", ");

        for (int i = 0; i < names.length; i++) {
            doesNameFit(names[i]);
        }
    }

    private static boolean doesNameFit(String name) {
        if (name.length() < 3 || name.length() > 16) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            Character current = name.charAt(i);
            if (!Character.isLetterOrDigit(current) && !current.equals('-') && !current.equals('_')) {
                return false;
            }
        }
        System.out.println(name);
        return true;
    }
}
