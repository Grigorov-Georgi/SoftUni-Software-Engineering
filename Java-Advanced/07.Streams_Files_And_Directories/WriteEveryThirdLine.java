import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("out3.txt"));

        String line = reader.readLine();

        int lineCounter = 1;
        while (line != null){
            lineCounter++;
            line = reader.readLine();

            if (lineCounter % 3 == 0){
                writer.write(line);
                writer.newLine();
            }
        }

        writer.close();
    }
}
