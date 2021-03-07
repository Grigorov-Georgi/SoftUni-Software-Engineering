package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2){
                String model = tokens[0];
                String id = tokens[1];
                Robot robot = new Robot(model, id);
                people.add(robot);
            }else if (tokens.length == 3){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Citizen citizen = new Citizen(name, age, id);
                people.add(citizen);
            }

            input = scanner.nextLine();
        }

        int neededNumber = Integer.parseInt(scanner.nextLine());

        for (Identifiable person : people) {
            int personIdLength = person.getId().length();
            if (person.getId().substring(personIdLength - 3, personIdLength).equals(String.valueOf(neededNumber))){
                System.out.println(person.getId());
            }
        }

    }
}
