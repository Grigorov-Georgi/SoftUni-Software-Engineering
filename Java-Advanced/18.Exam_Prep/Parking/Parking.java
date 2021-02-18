package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        this.data.add(car);
    }

    public boolean remove(String manufacturer, String model) {
        boolean canRemove = false;
        for (Car datum : this.data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                this.data.remove(datum);
                canRemove = true;
            }
        }
        return canRemove;
    }

    public Car getLatestCar() {
        Car neededCar = null;
        int latestYear = Integer.MIN_VALUE;
        for (Car datum : data) {
            if (datum.getYear() > latestYear) {
                latestYear = datum.getYear();
                neededCar = datum;
            }
        }
        return neededCar;
    }

    public Car getCar(String manufacturer, String model){
        Car neededCar = null;
        for (Car datum : data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                neededCar = datum;
            }
        }
        return neededCar;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type)).append(System.lineSeparator());
        for (Car datum : data) {
            sb.append(datum.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
