import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    String neededSubstring = tokens[1];
                    if (key.contains(neededSubstring)) {
                        System.out.println(key + " contains " + neededSubstring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    if (tokens[1].equals("Upper")) {
                        String oldSubstring = key.substring(startIndex, endIndex);
                        String substring = oldSubstring.toUpperCase();
                        key = key.substring(0, startIndex) + substring + key.substring(endIndex, key.length());
                    } else {
                        String oldSubstring = key.substring(startIndex, endIndex);
                        String substring = oldSubstring.toLowerCase();
                        key = key.substring(0, startIndex) + substring + key.substring(endIndex, key.length());
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    int startIndex1 = Integer.parseInt(tokens[1]);
                    int endIndex1 = Integer.parseInt(tokens[2]);
                    String sub = key.substring(startIndex1, endIndex1);
                    key = key.substring(0, startIndex1) + key.substring(endIndex1, key.length());
                    System.out.println(key);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + key);
    }
}
