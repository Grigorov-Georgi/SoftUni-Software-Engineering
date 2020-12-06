import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int insertIndex = Integer.parseInt(tokens[1]);
                    message = message.substring(0, insertIndex) + " " + message.substring(insertIndex, message.length());
                    System.out.println(message);
                    break;
                case "Reverse":
                    String sub = tokens[1];
                    if (message.contains(sub)) {
                        int indexOfSub = message.indexOf(sub);
                        StringBuilder sb = new StringBuilder();
                        sb.append(sub);
                        sb.reverse();
                        String reverseString = sb.toString();
                        int subLength = sub.length();
                        message = message.substring(0, indexOfSub) + message.substring(subLength + indexOfSub, message.length()) + reverseString;
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String changeSub = tokens[1];
                    String replacement = tokens[2];

                    message = message.replace(changeSub, replacement);
                    System.out.println(message);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
