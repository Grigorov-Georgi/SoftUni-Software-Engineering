import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gifts = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();

        while(!input.equals("No Money")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "OutOfStock":
                    for (int i = 0; i < gifts.length ; i++) {
                        if (gifts[i].equals(tokens[1])){
                            gifts[i] = "None";
                        }
                    }
                    break;
                case "Required":
                    String newGift = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= gifts.length -1) {
                        gifts[index] = newGift;
                    }
                    break;
                case "JustInCase":
                    gifts[gifts.length - 1] = tokens[1];
                    break;
            }
            input = scanner.nextLine();
        }

        for (String gift : gifts) {
            if (!gift.equals("None")){
                System.out.printf(gift + " ");
            }
        }
    }
}
