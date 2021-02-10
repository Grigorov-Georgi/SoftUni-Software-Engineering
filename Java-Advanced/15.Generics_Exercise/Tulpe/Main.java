package Tulpe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        Tulpe<String, String> tulpe = new Tulpe<>(name, tokens[2]);
        System.out.println(tulpe);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        Tulpe<String, Integer> tulpe1 = new Tulpe<>(name, liters);
        System.out.println(tulpe1);

        tokens = scanner.nextLine().split("\\s+");
        int firstNumber = Integer.parseInt(tokens[0]);
        double secondNumber = Double.parseDouble(tokens[1]);
        Tulpe<Integer, Double> tulpe2 = new Tulpe<>(firstNumber, secondNumber);
        System.out.println(tulpe2);

    }
}
