import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlantDiscovery {
    static class Plant {
        String name;
        int rarity;
        List<Double> ratings;

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addRating(double a) {
            this.ratings.add(a);
        }

        public void removeRatings() {
            this.ratings.clear();

        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public int getRarity() {
            return rarity;
        }

        public double getAverageRating() {
            if (ratings.isEmpty()) {
                return 0.0;
            }

            double averageRating = 0;
            for (double r : this.ratings) {
                averageRating += r;
            }
            averageRating = averageRating / ratings.size();
            return averageRating;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Plant> plantsByName = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            Plant p = new Plant(input[0], Integer.parseInt(input[1]));
            plantsByName.put(p.getName(), p);
        }


        String line = scanner.nextLine();

        while (!line.equals("Exhibition")) {
            String[] tokens = line.split(": ");
            String command = tokens[0];
            switch (command) {
                case "Rate":
                    String[] rateTokens = tokens[1].split(" - ");
                    String ratePlantName = rateTokens[0];
                    double rating = Double.parseDouble(rateTokens[1]);
                    if (plantsByName.get(ratePlantName) == null) {
                        System.out.println("error");
                    } else {
                        plantsByName.get(ratePlantName).addRating(rating);
                    }
                    break;
                case "Update":
                    String[] updateTokens = tokens[1].split(" - ");
                    String updatePlantName = updateTokens[0];
                    if (plantsByName.get(updatePlantName) == null) {
                        System.out.println("error");
                    } else {
                        plantsByName.get(updatePlantName).setRarity(Integer.parseInt(updateTokens[1]));
                    }
                    break;
                case "Reset":
                    String resetName = tokens[1];
                    if (plantsByName.get(resetName) == null) {
                        System.out.println("error");
                    } else {
                        plantsByName.get(resetName).removeRatings();
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }


            line = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantsByName
                .values()
                .stream()
                .sorted((a, b) -> {
                    if (a.getRarity() != b.getRarity()) {
                        return Integer.compare(b.getRarity(), a.getRarity());
                    } else {
                        return Double.compare(b.getAverageRating(), a.getAverageRating());
                    }
                })
                .map(p -> "- " + p.getName() + "; Rarity: " + p.getRarity() + "; Rating: " + String.format("%.2f", p.getAverageRating()))
                .forEach(p -> System.out.println(p));
    }
}
