package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (this.capacity > this.employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        boolean isRemoved = false;
        if (employees.contains(name)){
            employees.remove(name);
            isRemoved = true;
        }
        return isRemoved;
    }

    public Employee getOldestEmployee(){
        Employee employee = null;
        for (Employee e : employees) {
            if (employee == null || e.getAge() > employee.getAge()){
                employee = e;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery: " + this.name).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }


}
