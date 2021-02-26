package holiday;

public enum Seasons {
    AUTUMN(1),
    WINTER(3),
    SPRING(2),
    SUMMER(4);

    private int multiplier;

    Seasons(int multiplier){
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
