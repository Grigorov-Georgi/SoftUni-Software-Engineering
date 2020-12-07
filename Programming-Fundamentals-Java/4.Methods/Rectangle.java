import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        area(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()) );
    }
    static void area(int width, int height){
        System.out.println(width * height);
    }
}
