import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    static class Person {
        String name;
        String id;
        int age;

        Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Person> allPersons = new ArrayList<>();
        String input = scanner.nextLine();


        while (!input.equals("End")) {
            String[] arr = input.split(" ");
            Person person = new Person(arr[0], arr[1], Integer.parseInt(arr[2]));
            allPersons.add(person);
            input = scanner.nextLine();
        }
        allPersons.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).forEach(person -> System.out.println(person.toString()));
    }
}
