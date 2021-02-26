package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();
        while (!input.equals("Exit")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]){
                case "Create":
                    studentSystem.create(tokens);
                    break;
                case "Show":
                    System.out.println(studentSystem.show(tokens));
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
