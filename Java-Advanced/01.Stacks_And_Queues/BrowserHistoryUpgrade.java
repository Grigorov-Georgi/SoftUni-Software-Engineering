import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> future = new ArrayDeque<>();

        String site = null;
        String command = scanner.nextLine();;
        String futureElement = null;

        while (!command.equals("Home")){

            if (command.equals("forward")){
                if (futureElement != null) {
                    future.push(futureElement);
                }
                if (future.isEmpty()){
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                }else {
                    history.push(site);
                    site = future.pop();
                    futureElement = null;
                }
            }else if (command.equals("back")){
                if (history.isEmpty()){
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }else {
                    futureElement = site;
                    site = history.pop();
                }
            }else {
                future.clear();
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
