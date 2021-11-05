package exercise02_encapulation.p04_pizzaCalories;

import java.util.LinkedHashMap;
import java.util.Map;

public class Topping {

    private String toppingType;
    private double weight;

    private static final Map<String, Double> toppingModifiers;

    static {
        toppingModifiers = new LinkedHashMap<>();
        toppingModifiers.put("Meat", 1.2);
        toppingModifiers.put("Veggies", 0.8);
        toppingModifiers.put("Cheese", 1.1);
        toppingModifiers.put("Souse", 0.9);
    }

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String msg = String.format("%s weight should be in the range [1..50].", toppingType);
            throw new IllegalArgumentException(msg);
        }
    }

    private void setToppingType(String toppingType) {
        if (toppingModifiers.containsKey(toppingType)) {
            this.toppingType = toppingType;
        } else {
            String msg = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(msg);
        }
    }

    public double calculateCalories() {
        return (2 * this.weight) * toppingModifiers.get(this.toppingType);
    }
}
