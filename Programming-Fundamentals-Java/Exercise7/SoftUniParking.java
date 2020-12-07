import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, String> register = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String name = tokens[1];


            switch (command){
                case "register":
                    String plate = tokens[2];
                    if (!register.containsKey(name)) {
                        register.put(name, plate);
                        System.out.printf("%s registered %s successfully%n", name, plate);
                    }else {
                        System.out.println("ERROR: already registered with plate number " + register.get(name));
                    }
                    break;
                case "unregister":
                    if (!register.containsKey(name)){
                        System.out.println("ERROR: user " + name + " not found");
                    }else{
                        register.remove(name);
                        System.out.println(name + " unregistered successfully");
                    }
                    break;
            }
        }
        register.forEach((k,v) -> System.out.println(k + " => " + v));
    }
}
