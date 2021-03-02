package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        } else {
//            System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - ", this.getName()));
        String finalString;
        if (products.isEmpty()){
         sb.append("Nothing bought");
         finalString = sb.toString();
        } else {
            for (Product product : products) {
                sb.append(String.format("%s, ", product.getName()));
            }
            finalString = sb.toString().substring(0, sb.length() - 2);
        }
        return finalString.trim();
    }
}
