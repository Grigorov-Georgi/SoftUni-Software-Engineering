import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String, Long>> populationInfo = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("report")){
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).putIfAbsent(city, population);

            input = scanner.nextLine();
        }

        populationInfo.entrySet().stream().sorted((c1, c2) ->{
            long p1 = c1.getValue().values().stream().mapToLong(l -> l).sum();
            long p2 = c2.getValue().values().stream().mapToLong(l -> l).sum();

            return Long.compare(p2, p1);
        }).forEach(c -> {
            long totalPopualtion = c.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("%s (total population: %d)", c.getKey(), totalPopualtion));

            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet().stream().sorted((s1, s2) -> Long.compare(s2.getValue(), s1.getValue()))
                    .forEach(s -> System.out.println(String.format("=>%s: %d", s.getKey(), s.getValue())));

        });

    }
}
