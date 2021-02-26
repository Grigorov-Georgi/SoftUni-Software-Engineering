package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return this.studentsByName;
    }

    public void create(String name, int age, double grade) {
        if (!studentsByName.containsKey(name)) {
            Student student = new Student(name, age, grade);
            studentsByName.put(name, student);
        }
    }
    public void create(String[] tokens) {
        if (!studentsByName.containsKey(tokens[1])) {
            Student student = new Student(tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
            studentsByName.put(tokens[1], student);
        }
    }

    public String show(String name) {
        if (studentsByName.containsKey(name)) {
            Student neededStudent = studentsByName.get(name);
            return String.format("%s is %s years old. %s", neededStudent.getName(), neededStudent.getAge(), neededStudent.toString());
        }
        return "Error";
    }
    public String show(String[] tokens) {
        if (studentsByName.containsKey(tokens[1])) {
            Student neededStudent = studentsByName.get(tokens[1]);
            return String.format("%s is %s years old. %s", neededStudent.getName(), neededStudent.getAge(), neededStudent.toString());
        }
        return "Error";
    }

}
