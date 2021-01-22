import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // user       ip          messages
        Map<String, Map<String, Integer>> userInfo = new TreeMap<>();

        String input = scanner.nextLine();

        while(!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            userInfo.putIfAbsent(user, new LinkedHashMap<>());
            userInfo.get(user).putIfAbsent(ip, 0);
            userInfo.get(user).put(ip, userInfo.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userInfo.entrySet()) {
            System.out.println(entry.getKey() + ":");

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet() ) {
                sb.append(secondEntry.getKey() + " => " + secondEntry.getValue() + ", ");
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            System.out.println(finalOutput + ".");
        }
    }
}
