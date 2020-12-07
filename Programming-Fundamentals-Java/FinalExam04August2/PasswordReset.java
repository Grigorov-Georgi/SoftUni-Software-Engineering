import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        StringBuilder createdPassword = new StringBuilder();
        String input = scanner.nextLine();
        while (!input.equals("Done")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0){
                            createdPassword.append(password.charAt(i));
                        }
                    }
                    password = createdPassword.toString();
                    createdPassword = new StringBuilder();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password = password.substring(0, index) + password.substring(index + length, password.length());
                    System.out.println(password);
                    break;
                case "Substitute":
                    String neededText = tokens[1];
                    String replacingText = tokens[2];

                    if (password.contains(neededText)){
                        password = password.replace(neededText, replacingText);
                        System.out.println(password);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
