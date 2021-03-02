package shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(";");
        String[] secondArray = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        for (int i = 0; i < firstArray.length ; i++) {
            String[] tokens = firstArray[i].split("=");
            Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
            people.putIfAbsent(tokens[0], person);
        }
        for (int i = 0; i < secondArray.length ; i++) {
            String[] tokens = secondArray[i].split("=");
            Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
            products.putIfAbsent(tokens[0], product);
        }

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");
            String currentName = tokens[0];
            String currentProduct = tokens[1];
            people.get(currentName).buyProduct(products.get(currentProduct));

            command = scanner.nextLine();
        }

        for (Person person : people.values()) {
            System.out.println(person.toString());
        }

    }
}
