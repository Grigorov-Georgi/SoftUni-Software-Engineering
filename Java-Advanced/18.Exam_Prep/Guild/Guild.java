package guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player){
        if (roster.size() + 1 <= capacity){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public int count(){
        return roster.size();
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name) && player.getRank().equals("Trail")){
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name) && player.getRank().equals("Member")){
                player.setRank("Trail");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<Player> removedList = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                removedList.add(player);
            }
        }

        Player[] removedArray = new Player[removedList.size()];
        removedList.toArray(removedArray);
        return removedArray;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s", this.name)).append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
