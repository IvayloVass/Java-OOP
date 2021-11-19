package exercise05_polymorphism.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {
            String[] animalData = input.split("\\s+");

            Animal animal = getAnimal(animalData);

            String[] foodData = sc.nextLine().split("\\s+");

            Food food = getFood(foodData);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            input = sc.nextLine();
        }
        animals.forEach(System.out::println);
    }


    private static Food getFood(String[] foodData) {
        String foodType = foodData[0];
        int foodQty = Integer.parseInt(foodData[1]);
        if (foodType.equals("Vegetable")) {
            return new Vegetable(foodQty);
        } else {
            return new Meat(foodQty);
        }
    }

    private static Animal getAnimal(String[] animalData) {

        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];
        Animal animal = null;
        switch (animalType) {
            case "Cat":
                String breed = animalData[4];
                animal = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                break;
        }
        return animal;
    }
}
