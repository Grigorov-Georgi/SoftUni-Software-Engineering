import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date start = new Date();
        for (int i = 0; i < Integer.MAX_VALUE ; i++) {
        }
        Date end = new Date();
        long ms = end.getTime() - start.getTime();
        System.out.println(ms + " ms");
    }
}
