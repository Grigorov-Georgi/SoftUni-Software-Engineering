import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student{
        String firstName;
        String lastName;
        double grade;

        Student(String firstName, String lastName, double grade){
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }
        public String toString(){
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            Student student = new Student(array[0], array[1], Double.parseDouble(array[2]));
            students.add(student);
        }
        students.stream().sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade())).forEach(student -> System.out.println(student.toString()));
    }
}
