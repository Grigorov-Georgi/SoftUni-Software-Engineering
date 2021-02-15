package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        this.data.add(pet);
    }

    public boolean remove(String name){
        Pet neededPet = null;
        for (Pet datum : data) {
            if (datum.getName().equals(name)){
                neededPet = datum;
                this.data.remove(neededPet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        Pet neededPet = null;
        for (Pet datum : data) {
            if (datum.getName().equals(name) && datum.getOwner().equals(owner)){
                neededPet = datum;
            }
        }
        return neededPet;
    }

    public Pet getOldestPet(){
        Pet oldestPet = null;
        for (int i = 0; i < data.size() ; i++) {
            if (i == 0){
                oldestPet = data.get(i);
            }
            if (oldestPet.getAge() < data.get(i).getAge()){
                oldestPet = data.get(i);
            }
        }
        return oldestPet;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet datum : data) {
            sb.append(String.format("%s %s", datum.getName(), datum.getOwner())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}
