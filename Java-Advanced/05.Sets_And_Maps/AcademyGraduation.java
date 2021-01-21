import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, double[]> studentsWithGrades = new TreeMap<>();
        while (n-- > 0){

            String name = scanner.nextLine();
            double[] grade = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            studentsWithGrades.put(name, grade);
        }

        studentsWithGrades.forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, getAverage(v)));
    }
    private static String getAverage(double[] grades){
        String average;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        average = sum/grades.length + "";

        return average;
    }
}
