import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String user = tokens[1];

            companies.putIfAbsent(company, new ArrayList<>());
            List<String> list = companies.get(company);
            if (!list.contains(user)){
                list.add(user);
            }
            input = scanner.nextLine();
        }

        companies
                .entrySet()
                .stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue().forEach(id -> System.out.printf("-- %s%n", id));
                });
    }
}
