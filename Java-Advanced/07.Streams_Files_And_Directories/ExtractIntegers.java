import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        FileWriter writer = new FileWriter("out2.txt");

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scanner.next();
        }

        writer.flush(); // това може да се пропусне
        writer.close();

    }
}
