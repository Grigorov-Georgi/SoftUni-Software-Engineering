import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passowrd = scanner.nextLine();

        if (checkLength(passowrd) && checkIfConsist(passowrd) && atLeastTwoDigits(passowrd)) {
            System.out.println("Password is valid");
        }
        if (!checkLength(passowrd)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkIfConsist(passowrd)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!atLeastTwoDigits(passowrd)) {
            System.out.println("Password must have at least 2 digits");
        }

    }

    static boolean checkLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    static boolean checkIfConsist(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isDigit = Character.isDigit(symbol);
            boolean isLetter = Character.isLetter(symbol);
            if (!isLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    static boolean atLeastTwoDigits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)) {
                counter++;
            }
        }
        if (counter < 2) {
            return false;
        }
        return true;
    }
}
