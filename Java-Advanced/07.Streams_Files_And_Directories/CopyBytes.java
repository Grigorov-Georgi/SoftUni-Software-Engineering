import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out1.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        while(singleByte >= 0){

            if (singleByte == 10 || singleByte == 32){
                writer.print((char)singleByte);
            }else{
                writer.print(singleByte);
            }

            singleByte = inputStream.read();
        }

        writer.close();
        inputStream.close();
    }
}
