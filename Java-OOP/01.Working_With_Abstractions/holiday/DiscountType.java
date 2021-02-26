package holiday;

public enum DiscountType {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int precentage;

    DiscountType(int precentage){
        this.precentage = precentage;
    }

    public int getPrecentage() {
        return precentage;
    }
}
