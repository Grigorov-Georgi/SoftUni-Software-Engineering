import java.util.Scanner;

public class Crafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split("\\|");

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command){
                case "Move":
                    int index = Integer.parseInt(tokens[2]);
                    if (tokens[1].equals("Left")){
                        if (index - 1 >= 0 && index <= parts.length - 1) {
                            String leftPart = parts[index - 1];
                            parts[index - 1] = parts[index];
                            parts[index] = leftPart;
                        }
                    }else if (tokens[1].equals("Right")){
                        if (index + 1 <= parts.length - 1 && index >= 0) {
                            String rightPart = parts[index + 1];
                            parts[index + 1] = parts[index];
                            parts[index] = rightPart;
                        }
                    }
                    break;
                case "Check":
                    if (tokens[1].equals("Even")){
                        for (int i = 0; i < parts.length; i++) {
                            if (i % 2 == 0){
                                System.out.print(parts[i] + " ");
                            }
                        }
                        System.out.println();
                    }else if (tokens[1].equals("Odd")){
                        for (int i = 0; i < parts.length; i++) {
                            if (i % 2 != 0){
                                System.out.print(parts[i] + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        String line = String.join("", parts);
        System.out.printf("You crafted %s!", line);
    }
}
