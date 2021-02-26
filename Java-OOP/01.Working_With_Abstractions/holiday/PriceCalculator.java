package holiday;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private DiscountType discountType;
    private Seasons season;

    public PriceCalculator(double pricePerDay, int days, Seasons season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.discountType = discountType;
        this.season = season;
    }

    public double calculate(){
        return pricePerDay * days * season.getMultiplier() * (1 - discountType.getPrecentage() / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.calculate());
    }
}
