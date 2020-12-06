import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(", ");
        List<String> items = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            items.add(array[i]);
        }
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            switch (tokens[0]) {
                case "Collect":
                    if (!items.contains(tokens[1])) {
                        items.add(tokens[1]);
                    }
                    break;
                case "Drop":
                    if (items.contains(tokens[1])) {
                        items.remove(tokens[1]);
                    }
                    break;
                case "Combine Items":
                    String[] tokens2 = tokens[1].split(":");
                    if (items.contains(tokens2[0])){
                        int index = items.indexOf(tokens2[0]);
                        items.add(index + 1, tokens2[1]);
                    }
                    break;
                case "Renew":
                    String currentItem = tokens[1];
                    if (items.contains(tokens[1])){
                        items.remove(tokens[1]);
                        items.add(currentItem);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        String output = String.join(", ", items);
        System.out.println(output);

    }
}
