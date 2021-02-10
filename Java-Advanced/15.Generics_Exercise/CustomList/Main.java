package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<String>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Add":
                    String addElement = tokens[1];
                    customList.add(addElement);
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(tokens[1]);
                    customList.remove(removeIndex);
                    break;
                case "Contains":
                    String containsElement = tokens[1];
                    System.out.println(customList.contains(containsElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String greaterElement = tokens[1];
                    System.out.println(customList.countGreaterThan(greaterElement));
                    break;
                case "Max":
                    customList.getMax();
                    break;
                case "Min":
                    customList.getMin();
                    break;
                case "Print":
                    customList.print();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
