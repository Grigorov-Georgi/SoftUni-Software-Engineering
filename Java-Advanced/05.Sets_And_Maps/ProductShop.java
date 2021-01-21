import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> productsMap = new TreeMap<>();

        while(!"Revision".equals(input)){
            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            productsMap.putIfAbsent(shop, new LinkedHashMap<>());
            productsMap.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        productsMap.forEach((k, v) -> {
            System.out.println(k + "->");
            v.forEach((key, value) -> {
                System.out.printf("Product: %s, Price: %.1f%n", key, value);
            });
        });
    }
}
