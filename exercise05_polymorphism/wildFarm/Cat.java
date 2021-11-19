package exercise05_polymorphism.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private final String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    protected void makeSound() {
        System.out.println("Meowwww");

    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), this.breed
                , formatter.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }

}
