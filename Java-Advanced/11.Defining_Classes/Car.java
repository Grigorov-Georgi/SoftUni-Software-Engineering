import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public Car(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand){
        this(brand, "unknown", -1);
    }

    public String getBrand(){
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsePower == car.horsePower &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }
}
