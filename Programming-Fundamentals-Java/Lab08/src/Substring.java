import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyWord = scanner.nextLine();
        String line = scanner.nextLine();
        int currentIndex = 0;
        int nextWordIndex = line.indexOf(keyWord, currentIndex);

        String result = line;

        while (nextWordIndex != -1) {
            List<String> list = new ArrayList<>();
            while (nextWordIndex != -1) {
                list.add(result.substring(currentIndex, nextWordIndex));
                currentIndex = nextWordIndex + keyWord.length();
                nextWordIndex = result.indexOf(keyWord, currentIndex);
            }
            list.add(result.substring(currentIndex));
            result = String.join("", list);
            currentIndex = 0;
            nextWordIndex = result.indexOf(keyWord, currentIndex);
        }


        System.out.println(result);
    }
}
