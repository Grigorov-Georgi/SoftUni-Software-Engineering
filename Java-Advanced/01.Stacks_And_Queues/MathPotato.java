import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        ArrayDeque<String> kids = new ArrayDeque<>();

        for (String name : names) {
            kids.offer(name);
        }

        while (kids.size() > 1){

            for (int i = 1; i < n ; i++) {
                kids.offer(kids.poll());
            }
            if (isPrime(cycle)){
                System.out.println("Prime " + kids.peek());
            }else{
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());
    }


    public static boolean isPrime(int number){
        int counter = 1;
        if (number == 1){
            return false;
        }
        for (int i = 2; i <= number; i++) {
            if (number % i == 0){
                counter++;
            }
        }
        boolean isPrime = true;
        if (counter > 2){
            isPrime = false;
        }
        return isPrime;
    }
}
