package exercise05_polymorphism.wildFarm;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected abstract void makeSound();

    protected void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }


}
