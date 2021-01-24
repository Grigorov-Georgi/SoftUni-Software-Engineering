import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int singleByte = inputStream.read();

        while (singleByte >= 0){
            System.out.printf("%s ", Integer.toBinaryString(singleByte));

            singleByte = inputStream.read();
        }
        inputStream.close();
    }
}
