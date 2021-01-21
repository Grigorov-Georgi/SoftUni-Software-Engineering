import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> averageStudentsGrades = new TreeMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            averageStudentsGrades.putIfAbsent(name, new ArrayList<>());
            averageStudentsGrades.get(name).add(grade);
        }
        List<String> test = new ArrayList<>();


        averageStudentsGrades.entrySet()
                .forEach(e -> {
                    System.out.printf("%s -> ", e.getKey());
                    e.getValue().forEach(s -> System.out.printf("%.2f ", s));
                    System.out.printf("(avg: %.2f)", getAverage(e.getValue()));
                    System.out.println();
                });
    }
    private static double getAverage (List<Double> grades){
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum/grades.size();
    }
}
