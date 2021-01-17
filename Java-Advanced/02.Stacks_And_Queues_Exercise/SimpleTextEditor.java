import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operationNumber = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> undoStack = new ArrayDeque<>();


        for (int i = 0; i < operationNumber; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command){
                case "1":
                    undoStack.push(sb.toString());
                    sb.append(tokens[1]);
                    break;
                case "2":
                    undoStack.push(sb.toString());
                    int count = Integer.parseInt(tokens[1]);
                    int start = sb.length() - count;
                    sb.delete(start, start + count);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    if (!undoStack.isEmpty()){
                        sb = new StringBuilder(undoStack.pop());
                    }
                    break;
            }


        }
    }
}
