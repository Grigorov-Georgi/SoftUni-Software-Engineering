import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);

        boolean isFound = false;


        while (!isFound) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int count = Integer.parseInt(tokens[i]);
                String itemType = tokens[i + 1].toLowerCase();
                if (keyMaterials.containsKey(itemType)) {
                    addToMap(keyMaterials, count, itemType);
                    isFound = isFound(keyMaterials, itemType);
                    if (isFound) {
                        break;
                    }
                } else {
                    addToMap(junk, count, itemType);
                }
            }
        }

        keyMaterials
                .entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = i2.getValue().compareTo(i1.getValue());
                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                        .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
        junk
                .entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
    }

    private static boolean isFound(Map<String, Integer> map, String itemType) {
        if (map.get(itemType) >= 250) {
            int newCount = map.get(itemType) - 250;
            map.put(itemType, newCount);
            switch (itemType) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    break;

            }
            return true;
        }
        return false;
    }

    private static void addToMap(Map<String, Integer> map, int count, String itemType) {
        map.putIfAbsent(itemType, 0);
        int newCount = map.get(itemType) + count;
        map.put(itemType, newCount);
    }
}
