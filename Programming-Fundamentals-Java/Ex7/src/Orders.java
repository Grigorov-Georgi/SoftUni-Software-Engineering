import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> quantityMap = new LinkedHashMap<>();
        Map<String, Double> priceMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            priceMap.put(product, price);
            quantityMap.putIfAbsent(product, 0);
            int newQuantity = quantityMap.get(product) + Integer.parseInt(tokens[2]);
            quantityMap.put(product, newQuantity);

            input = scanner.nextLine();
        }
        quantityMap.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v * priceMap.get(k)));
    }
}
