import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourceMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());

            resourceMap.putIfAbsent(input, 0);
            resourceMap.put(input, resourceMap.get(input) + quantity);

            input = scanner.nextLine();
        }

        resourceMap.forEach((k,v) -> System.out.println(k + " -> "+ v));
    }
}
