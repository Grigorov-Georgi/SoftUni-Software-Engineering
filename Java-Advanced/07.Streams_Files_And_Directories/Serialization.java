import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws Exception{
        String path = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop" +
                "\\Java2\\Java-Advanced\\07.Streams_Files_And_Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        List<String> names = new ArrayList<>();

        names.add("Asen");
        names.add("Peter");
        names.add("Krum");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("list.txt"));

        outputStream.writeObject(names);

        outputStream.close();


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("list.txt"));
        List<String> readName = (List<String>) inputStream.readObject();

        for (String s : readName) {
            System.out.println(s);
        }
    }
}
