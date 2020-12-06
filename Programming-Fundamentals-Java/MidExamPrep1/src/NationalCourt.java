import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("!");
        List<String> items = new ArrayList<>();

        for (int i = 0; i < array.length ; i++) {
            items.add(array[i]);
        }

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")){
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String product = tokens[1];

            switch (command){
                case "Urgent":
                    if (!items.contains(product)){
                        items.add(0, product);
                    }
                    break;
                case "Unnecessary":
                    if (items.contains(product)){
                        items.remove(product);
                    }
                    break;
                case "Correct":
                    String secondProduct = tokens[2];
                    if (items.contains(product)){
                        int i = items.indexOf(product);
                        items.set(i, secondProduct);
                    }
                    break;
                case "Rearrange":
                    if (items.contains(product)){
                        items.remove(product);
                        items.add(product);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        String productList = String.join(", ", items);
        System.out.println(productList);

    }
}
