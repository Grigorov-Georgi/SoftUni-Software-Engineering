package definingClassesExercises.carSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String displacement){
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency){
        this(model, power, "n/a", efficiency);
    }

    public Engine(String model, int power){
        this(model, power, "n/a", "n/a");
    }
}
