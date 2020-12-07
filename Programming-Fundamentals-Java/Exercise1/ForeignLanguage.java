import java.util.Scanner;

public class ForeignLanguage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String language = scanner.nextLine();
        if (language.equals("England") || language.equals("USA")){
            System.out.println("English");
        }else if (language.equals("Mexico") || language.equals("Spain") || language.equals("Argentina")){
            System.out.println("Spanish");
        }else{
            System.out.println("unknown");
        }
    }
}
