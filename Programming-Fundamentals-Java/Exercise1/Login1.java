import java.util.Scanner;

public class Login1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int length = name.length();
        String password = "";

        for (int i = length - 1; i >= 0 ; i--) {
            password = String.format(password + name.charAt(i));
        }
        int counter = 0;
        String typingPassword = scanner.nextLine();
        while (!typingPassword.equals(password)) {
            counter++;
            if (counter == 4){
                System.out.printf("User %s blocked!", name);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            typingPassword = scanner.nextLine();
        }
        System.out.printf("User %s logged in!", name);
    }
}
