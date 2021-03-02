package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.trim().length() < 1 || name == null){
            throw new IllegalStateException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalStateException("Age shold be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
    }

    private double calculateProductPerDay(){
        double result;
        if (this.age >= 0 && this.age <= 5){
            result = 2;
        }else if(this.age >= 6 && this.age <= 11){
            result = 1;
        }else {
            result = 0.75;
        }
        return result;
    }
}
