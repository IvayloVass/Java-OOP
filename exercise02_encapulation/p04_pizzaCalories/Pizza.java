package exercise02_encapulation.p04_pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int countOfToppings) {
        this.setName(name);
        this.setToppings(countOfToppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.trim().length() > 15) {
            throw new IllegalArgumentException("exercise02_encapulation.p04_pizzaCalories.Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int countOfToppings) {
        if (countOfToppings >= 0 && countOfToppings <= 10) {
            this.toppings = new ArrayList<>(countOfToppings);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");

        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double doughCalories = this.dough.calculateCalories();
        double sumToppingCalories = toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        return doughCalories + sumToppingCalories;
    }
}
