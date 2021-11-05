package exercise02_encapulation.p03_choppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            String message = String.format("%s can't afford %s\n", this.name, product.getName());
            throw new IllegalArgumentException(message);
        }
        products.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s\n", this.name, product.getName());
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }
}

