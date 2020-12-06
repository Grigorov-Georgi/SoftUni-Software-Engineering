import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        double fullCourses = Math.ceil((double)n / p);
        System.out.printf("%.0f", fullCourses);
//        if (p >= n){
//            System.out.println("All the persons fit inside in the elevator. Only one course is needed.");
//        }else if (n % p == 0){
//            System.out.printf("%.0f courses * %d people", fullCourses, p);
//        }else {
//            double lastPeople = n - (fullCourses * p);
//            System.out.printf("%.0f courses * %d people + 1 course * %.0f persons", fullCourses, p, lastPeople);
//        }
    }
}
