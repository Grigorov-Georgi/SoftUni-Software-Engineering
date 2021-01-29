import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Predicate<String>> predicateMap = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Print")) {
            String[] tokens = line.split(";");
            String predicateName = tokens[1] + tokens[2];

            if (tokens[0].contains("Add")) {
                Predicate<String> predicate = getPredicate(tokens);
                predicateMap.put(predicateName, predicate);

            } else {
                predicateMap.remove(predicateName);
            }

            line = scanner.nextLine();
        }
        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicateMap.values()) {
                if (predicate.test(guest)){
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.println(e + " "));
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        if (tokens[1].equals("Starts with")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("Ends with")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else if (tokens[1].equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }else if (tokens[1].equals("Contains")){
            predicate = name -> name.contains(tokens[2]);
        }

        return predicate;
    }
}
