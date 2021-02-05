package definingClassesExercises.google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while(!line.equals("End")){
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String neededClass = tokens[1];

            Person person = null;
            if (!people.containsKey(name)) {
                person = new Person(name);
            }else{
                person = people.get(name);
            }

            switch (neededClass){
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String type = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBDay = tokens[3];
                    Parents parents = new Parents(parentName, parentBDay);
                    person.addParent(parents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children children = new Children(childName, childBirthday);
                    person.addChild(children);
                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(model, speed);
                    person.setCar(car);
                    break;
            }

            people.put(name, person);

            line = scanner.nextLine();
        }

        String neededInfo = scanner.nextLine();

        System.out.println(people.get(neededInfo).toString());

    }
}
