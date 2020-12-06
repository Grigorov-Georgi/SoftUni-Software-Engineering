import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s+");
        List<String> shops = new ArrayList<>();

        for (int i = 0; i < array.length ; i++) {
            shops.add(array[i]);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Include":
                    shops.add(tokens[1]);
                    break;
                case "Visit":
                    if ((Integer.parseInt(tokens[2]) <= shops.size()) && (Integer.parseInt(tokens[2]) > 0)) {
                        if (tokens[1].equals("first")) {
                            for (int j = 0; j < Integer.parseInt(tokens[2]) ; j++) {
                                shops.remove(0);
                            }
                        } else if (tokens[1].equals("last")) {
                            for (int j = 0; j < Integer.parseInt(tokens[2]) ; j++) {
                                shops.remove(shops.size() - 1);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    if ((index1 >= 0 && index1 <= shops.size() - 1) && (index2 >= 0 && index2 <= shops.size() - 1)){
                        String firstShop = shops.get(index1);
                        String secondShop = shops.get(index2);
                        shops.add(index1, secondShop);
                        shops.remove(index1 + 1);
                        shops.add(index2, firstShop);
                        shops.remove(index2 + 1);
                    }
                    break;
                case "Place":
                    if ((Integer.parseInt(tokens[2]) + 1 <= shops.size() - 1) && (Integer.parseInt(tokens[2]) + 1 >= 0)) {
                        shops.add(Integer.parseInt(tokens[2]) + 1, tokens[1]);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        String line = String.join(" ", shops);
        System.out.println(line);

    }
}
