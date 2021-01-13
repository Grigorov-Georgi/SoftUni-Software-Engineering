import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String site = null;
        String command = scanner.nextLine();;

        while (!command.equals("Home")){

            if (command.equals("back")){
                if (history.isEmpty()){
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }else {
                    site = history.pop();
                }
            }else {
                if (site != null){
                    history.push(site);
                }
                site = command;
            }
            System.out.println(site);

            command = scanner.nextLine();
        }
    }
}
