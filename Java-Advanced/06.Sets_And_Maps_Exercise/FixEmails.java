import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mailsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")){
            String mail = scanner.nextLine();
            String[] tokens = mail.split("\\.");
            if (!tokens[1].equalsIgnoreCase("com") && !tokens[1].equalsIgnoreCase("us") && !tokens[1].equalsIgnoreCase("uk")){
                mailsMap.put(input, mail);
            }
            input = scanner.nextLine();
        }

        mailsMap.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
