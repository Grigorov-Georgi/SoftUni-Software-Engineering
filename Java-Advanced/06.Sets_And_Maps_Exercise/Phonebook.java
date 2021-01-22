import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"search".equals(input)) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];

            phonebook.put(name, phone);

            input = scanner.nextLine();
        }

        String cmd = scanner.nextLine();

        while(!"stop".equals(cmd)){
            if (phonebook.containsKey(cmd)){
                System.out.println(cmd + " -> " + phonebook.get(cmd));
            }else {
                System.out.println("Contact "+ cmd + " does not exist.");
            }


            cmd = scanner.nextLine();
        }
    }
}
