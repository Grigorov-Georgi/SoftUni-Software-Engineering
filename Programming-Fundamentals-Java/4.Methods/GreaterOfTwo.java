import java.util.Scanner;

public class GreaterOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getMax(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
    }
    static void getMax(String var, String a, String b){
        switch (var){
            case "char":
                if (a.charAt(0) > b.charAt(0)){
                    System.out.println(a);
                }else {
                    System.out.println(b);
                }
                break;
            case "string":
                int sumA = 0;
                int sumB = 0;
                for (int i = 0; i < a.length(); i++) {
                    sumA += a.charAt(i);
                }
                for (int i = 0; i < b.length(); i++) {
                    sumB += b.charAt(i);
                }
                if (sumA > sumB){
                    System.out.println(a);
                }else {
                    System.out.println(b);
                }
                break;
            case "int":
                if (Integer.parseInt(a) > Integer.parseInt(b)){
                    System.out.println(a);
                }else {
                    System.out.println(b);
                }
                break;
        }
    }
}
