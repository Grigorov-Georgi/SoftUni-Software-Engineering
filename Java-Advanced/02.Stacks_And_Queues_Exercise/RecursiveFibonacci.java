import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memoizeTableArray = new long[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        memoizeTableArray[0] = 1;
        memoizeTableArray[1] = 1;

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(n));



    }

    public static long getFibonacci(int n) {
        if (memoizeTableArray[n] != 0){
            return memoizeTableArray[n];
        }else {
            long result = getFibonacci(n - 1) + getFibonacci(n - 2);
            memoizeTableArray[n] = result;
            return result;
        }
    }
}
