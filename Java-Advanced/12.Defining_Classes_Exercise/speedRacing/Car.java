package definingClassesExercises.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public void drive(int distance){
        if (distance > this.fuelAmount / this.fuelCost){
            System.out.println("Insufficient fuel for the drive");
        }else {
            this.distanceTraveled += distance;
            double usedFuel = distance * fuelCost;
            fuelAmount -= usedFuel;
        }
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
