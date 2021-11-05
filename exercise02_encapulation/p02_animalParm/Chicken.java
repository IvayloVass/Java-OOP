package exercise02_encapulation.p02_animalParm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setAge(int age) {
        if (age > 15 || age < 0) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    private double calculateProductPerDay() {
        double dailyProduction = 0.0;
        if (this.age <= 5) {
            dailyProduction = 2;
        } else if (this.age <= 11) {
            dailyProduction = 1;
        } else if (this.age < 15) {
            dailyProduction = 0.75;
        }
        return dailyProduction;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, productPerDay());
    }
}

