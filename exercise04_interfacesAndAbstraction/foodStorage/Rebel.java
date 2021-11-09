package exercise04_interfacesAndAbstraction.foodStorage;

public class Rebel implements Person, Buyer {

    private static final int FOOD_INCREMENT = 5;

    private String name;
    private int age;
    private String group;
    private int food;


    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        this.foodIncrement();
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void foodIncrement() {
        this.food += FOOD_INCREMENT;
    }
}
