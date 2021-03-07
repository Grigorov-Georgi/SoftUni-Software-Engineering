package carShopExtend;

public class Seat extends CarImpl implements Sellable{
    private Double price;



    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        String result = String.format("%s%n%s sells for %.6f", super.toString(), this.model, this.price);
        return result;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
