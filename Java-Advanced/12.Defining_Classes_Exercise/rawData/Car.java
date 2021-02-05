package definingClassesExercises.rawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    public Car(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTire1(Tire tire1) {
        this.tire1 = tire1;
    }

    public void setTire2(Tire tire2) {
        this.tire2 = tire2;
    }

    public void setTire3(Tire tire3) {
        this.tire3 = tire3;
    }

    public void setTire4(Tire tire4) {
        this.tire4 = tire4;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return model;
    }

    public boolean fragile() {
        if ((tire1.getPressure() < 1 || tire2.getPressure() < 1 || tire3.getPressure() < 1 || tire4.getPressure() < 1) && cargo.getType().equals("fragile")) {
         return true;
        }
        return false;
    }
    public boolean flamable(){
        if (engine.getPower() > 250 && cargo.getType().equals("flamable")){
            return true;
        }
        return false;
    }
}
