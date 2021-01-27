import java.io.*;
import java.util.List;

public class SerializeArrayList {

    private static final String PATH = "src\\resources\\list.ser";

    public static void main(String[] args) {

        List<Double> list = List.of(3.2, 4.3, 5.0);

        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(list);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            List<Double> deserializedList = (List<Double>) ois.readObject();
            deserializedList.forEach(e -> System.out.println(e));
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }
}
