package vehicleExtension;

import java.text.DecimalFormat;

public class Vehicle implements IVehicle {
    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    @Override
    public String drive(double distance){
        double fuelNeed = distance * fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";
        if (this.fuelQuantity >= fuelNeed){
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeed;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0 ){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
            this.fuelQuantity += liters;

    }
}
