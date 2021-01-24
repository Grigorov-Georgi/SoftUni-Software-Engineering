import java.io.File;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop" +
                "\\Java2\\Java-Advanced\\07.Streams_Files_And_Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()){
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }
    }
}
