import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Song {

    static class Songs {
        String typeList;
        String name;
        String time;

       Songs(String typeList, String name, String time){
        this.typeList = typeList;
        this.name = name;
        this.time = time;
        }

        public String getSongs(){
           return typeList;
        }
        public String getName(){
           return name;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Songs> songs = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());



        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("_");
            Songs song = new Songs(tokens[0], tokens[1], tokens[2]);
            songs.add(song);

        }
        String typeList = scanner.nextLine();
        if (typeList.equals("all")){
            for (Songs s: songs) {
                System.out.println(s.getName());
            }
        }else {
            for (Songs s: songs) {
                if (typeList.equals(s.getSongs())){
                    System.out.println(s.getName());
                }

            }
        }


    }
}
