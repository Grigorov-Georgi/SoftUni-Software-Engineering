package definingClassesExercises.rawData;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getType() {
        return type;
    }
}
