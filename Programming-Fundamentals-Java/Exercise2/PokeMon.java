import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int nStart = n;
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean f = false;
        while (n >= m){
            n -= m;

            if (n == m && (!f)){
                if (y != 0) {
                    n /= y;
                }
            }
            f = true;
            counter++;
        }
        System.out.println(n);
        System.out.println(counter);
    }
}
