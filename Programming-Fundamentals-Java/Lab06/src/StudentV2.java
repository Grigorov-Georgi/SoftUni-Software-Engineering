import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentV2 {

    static class Student {
        String firstName;
        String secondName;
        int age;
        String town;

        Student(String firstName, String secondName, int age, String town) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.town = town;
        }

        public String getTown() {
            return town;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];
            Student student = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
            int exsistingIndex = findStudentIndex(students, student.firstName, student.secondName);
            if (exsistingIndex != -1) {
                students.get(exsistingIndex).setAge(student.age);
                students.get(exsistingIndex).setTown(student.town);
            } else {
                students.add(student);
            }

            input = scanner.nextLine();
        }

        String neededTown = scanner.nextLine();
        for (Student s : students) {
            if (neededTown.equals(s.getTown())) {
                System.out.printf("%s %s is %d years old%n", s.firstName, s.secondName, s.age);
            }
        }


    }
    static int findStudentIndex(List<Student> students, String firstName, String secondName){
        for (int i = 0; i < students.size() ; i++) {
            if (firstName.equals(students.get(i).getFirstName()) && secondName.equals(students.get(i).getSecondName())){
                return i;
            }
        }
        return -1;
    }
}


