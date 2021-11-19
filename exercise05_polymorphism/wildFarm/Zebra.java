package exercise05_polymorphism.wildFarm;

import java.text.DecimalFormat;

public class Zebra extends Mammal {


    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");

    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName()
                , formatter.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }

}
