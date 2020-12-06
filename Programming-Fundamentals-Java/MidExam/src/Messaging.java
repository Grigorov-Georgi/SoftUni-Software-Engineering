import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> messages = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Chat":
                    messages.add(tokens[1]);
                    break;
                case "Delete":
                    if (messages.contains(tokens[1])) {
                        messages.remove(tokens[1]);
                    }
                    break;
                case "Edit":
                    String messageToEdit = tokens[1];
                    String editedVersion = tokens[2];
                    int indexOfMessage = messages.indexOf(messageToEdit);
                    messages.add(indexOfMessage, editedVersion);
                    messages.remove(indexOfMessage + 1);
                    break;
                case "Pin":
                    messages.remove(tokens[1]);
                    messages.add(tokens[1]);
                    break;
                case "Spam":
                    for (int i = 1; i < tokens.length; i++) {
                        messages.add(tokens[i]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (String m : messages) {
            System.out.println(m);
        }
    }
}
