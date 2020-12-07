import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static class Piece {
        String name;
        String composer;
        String key;

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Piece> songMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            String piece = line[0];
            String composer = line[1];
            String key = line[2];
            Piece piece1 = new Piece(piece, composer, key);
            songMap.put(piece, piece1);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String neededSong = tokens[1];
                    if (songMap.containsKey(neededSong)) {
                        System.out.println(neededSong + " is already in the collection!");
                    } else {
                        Piece current = new Piece(tokens[1], tokens[2], tokens[3]);
                        songMap.put(neededSong, current);
                        System.out.println(neededSong + " by " + tokens[2] + " in " + tokens[3] + " added to the collection!");
                    }
                    break;
                case "Remove":
                    String removeSong = tokens[1];
                    if (songMap.containsKey(removeSong)) {
                        songMap.remove(removeSong);
                        System.out.println("Successfully removed " + removeSong + "!");
                    } else {
                        System.out.println("Invalid operation! " + removeSong + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String changePiece = tokens[1];
                    String newKey = tokens[2];
                    if (songMap.containsKey(changePiece)) {
                        songMap.get(changePiece).setKey(newKey);
                        System.out.println("Changed the key of " + changePiece + " to " + newKey + "!");
                    } else {
                        System.out.println("Invalid operation! " + changePiece + " does not exist in the collection.");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        songMap.values()
                .stream()
                .sorted((a, b) -> {
                    if (a.getName() != b.getName()){
                        return a.getName().compareTo(b.getName());
                    }else {
                        return a.getComposer().compareTo(b.getComposer());
                    }
        }).forEach(s -> System.out.println(s.getName() + " -> Composer: " + s.getComposer() + ", Key: " + s.getKey()));
    }
}
