import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("&");
        List<String> books = new ArrayList<>();

        for (int i = 0; i < arr.length ; i++) {
            books.add(arr[i]);
        }

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String[] tokens = input.split(" \\| ");
            String command = tokens[0];

            switch (command){
                case "Add Book":
                    if (!books.contains(tokens[1])){
                        books.add(0, tokens[1]);
                    }
                    break;
                case "Take Book":
                    if (books.contains(tokens[1])){
                        books.remove(tokens[1]);
                    }
                    break;
                case "Swap Books":
                    if (books.contains(tokens[1]) && books.contains(tokens[2])){
                        int firstBookPosition = books.indexOf(tokens[1]);
                        int secondBookPosition = books.indexOf(tokens[2]);
                        books.remove(tokens[1]);
                        books.remove(tokens[2]);
                        books.add(firstBookPosition,  tokens[2]);
                        books.add(secondBookPosition,  tokens[1]);
                    }
                    break;
                case "Insert Book":
                    books.add(tokens[1]);
                    break;
                case "Check Book":
                    if (Integer.parseInt(tokens[1]) >= 0 && Integer.parseInt(tokens[1]) <= books.size() - 1 ){
                        System.out.println(books.get(Integer.parseInt(tokens[1])));
                    }
                    break;
            }
            input = scanner.nextLine();


        }
        String line = String.join(", ", books);
        System.out.println(line);
    }
}
