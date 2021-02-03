package definingClassesExercises.compantyRoster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departmentMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while(n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            departmentMap.putIfAbsent(department, new Department());

            if (tokens.length == 6){
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }else if (tokens.length == 4){
                employee = new Employee(name, salary, position, department);
            }else if (tokens.length == 5){
                if (tokens[4].contains("@")){
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }else{
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            departmentMap.get(department).addEmployee(employee);
        }

        double bestAvgSalary = Integer.MIN_VALUE;
        String bestDepartment = "";
        for (var department : departmentMap.entrySet()) {
            if (department.getValue().getAverageSalary() > bestAvgSalary){
                bestAvgSalary = department.getValue().getAverageSalary();
                bestDepartment = department.getKey();
            }
        }

        Department department = departmentMap.get(bestDepartment);

        System.out.println(String.format("Highest Average Salary: %s", bestDepartment));

        department.getEmployeeList().stream().sorted((s1,s2) -> Double.compare(s2.getSalary(), s1.getSalary())).forEach(e -> System.out.println(e.toString()));


    }

}
