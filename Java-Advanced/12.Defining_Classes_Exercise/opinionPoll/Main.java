package definingClassesExercises.opinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Map<Person, Boolean> peopleMap = new LinkedHashMap<>();

        List<OpinionPoll.Person> peopleList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

//        while (n-- > 0){
//            String[] tokens = scanner.nextLine().split("\\s+");
//            String currentName = tokens[0];
//            int currentAge = Integer.parseInt(tokens[1]);
//
//            Person person = new Person(currentName, currentAge);
//            peopleMap.put(person, false);
//            if (person.getAge() > 30){
//                peopleMap.put(person, true);
//            }
//        }
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String currentName = tokens[0];
            int currentAge = Integer.parseInt(tokens[1]);

            OpinionPoll.Person person = new OpinionPoll.Person(currentName, currentAge);
            if (person.getAge() > 30) {
                peopleList.add(person);
            }
        }

        peopleList.stream().sorted((n1, n2) -> {
            String name1 = n1.getName();
            String name2 = n2.getName();
            return name1.compareTo(name2);
        }).forEach(e -> System.out.printf(e.toString()));
//        peopleMap.entrySet().stream().filter(e -> e.getValue()).sorted((n1, n2) -> {
//            String name1 = n1.getKey().getName();
//            String name2 = n2.getKey().getName();
//            return name1.compareTo(name2);
//        }).forEach(e -> System.out.printf("%s - %d%n", e.getKey().getName(), e.getKey().getAge()));
    }
}
