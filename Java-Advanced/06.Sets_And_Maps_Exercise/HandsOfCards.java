import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> pointsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")){
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            pointsMap.putIfAbsent(name, new ArrayList<>());
            for (int i = 0; i < cards.length ; i++) {
                if (!pointsMap.get(name).contains(cards[i])) {
                    pointsMap.get(name).add(cards[i]);
                }
            }

            input = scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry : pointsMap.entrySet()) {
            int score = 0;
            for (String card : entry.getValue()) {
                String cardNumber = card.substring(0, card.length() - 1);
                String cardType = card.substring(card.length() - 1);

                int number = 0;
                if (Character.isDigit(cardNumber.charAt(0))){
                    number = Integer.parseInt(cardNumber);
                }else{
                    switch (cardNumber){
                        case "J":
                            number = 11;
                            break;
                        case "Q":
                            number = 12;
                            break;
                        case "K":
                            number = 13;
                            break;
                        case "A":
                            number = 14;
                            break;
                    }
                }
                int multiplier = 0;
                switch (cardType){
                    case "C":
                        multiplier = 1;
                        break;
                    case "D":
                        multiplier = 2;
                        break;
                    case "H":
                        multiplier = 3;
                        break;
                    case "S":
                        multiplier = 4;
                        break;
                }
                score += number * multiplier;
            }
            System.out.println(entry.getKey() + ": " + score);
        }

    }
}
