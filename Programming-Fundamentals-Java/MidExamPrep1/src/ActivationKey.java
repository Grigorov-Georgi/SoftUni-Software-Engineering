import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String[] aKey = activationKey.split("");
        List<String> keys = new ArrayList<>();
        for (int i = 0; i <aKey.length ; i++) {
            keys.add(aKey[i]);
        }
        String input = scanner.nextLine();

        while (!input.equals("Generate")){
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command){
                case "Contains":
                    String substring = tokens[1];
                    String[] substringChars = substring.split("");
                    boolean isntContain = false;
                    for (int i = 0; i < keys.size() ; i++) {
                        if (keys.get(i).equals(substringChars[0])){
                            if (keys.get(i+1).equals(substringChars[1])){
                                if (keys.get(i+2).equals(substringChars[2])){
                                    String line1 = String.join("", keys);
                                    String line2 = String.join("",substringChars);
                                    System.out.println(line1 + " contains " + line2);
                                }
                            }
                        }else{
                            isntContain = true;
                        }
                    }
                    if (isntContain){
                        System.out.println("Substring not found!");
                    }

                    break;
                case "Flip":
                    String position = tokens[1];
                    int indexA = Integer.parseInt(tokens[2]);
                    int indexB = Integer.parseInt(tokens[3]);
                    if (position.equals("Upper")){
                        for (int i = indexA; i < indexB ; i++) {
                            String oldChar = keys.get(i);
                            keys.remove(i);
                            keys.add(i, oldChar.toUpperCase());
                        }
                        String li = String.join("", keys);
                        System.out.println(li);
                    }else {
                        for (int i = indexA; i < indexB; i++) {
                            String oldChar = keys.get(i);
                            keys.remove(i);
                            keys.add(i, oldChar.toLowerCase());
                        }
                        String li1 = String.join("", keys);
                        System.out.println(li1);
                    }
                    break;
                case "Slice":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    for (int i = index1; i < index2 ; i++) {
                        keys.remove(index1);
                    }
                    String line = String.join("", keys);
                    System.out.println(line);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + String.join("", keys));
    }
}
