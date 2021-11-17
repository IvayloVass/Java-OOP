package lab05_polymorphism.Animals;

public class Dog extends Animal {


    public Dog(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf() + "DJAAF";
    }
}
