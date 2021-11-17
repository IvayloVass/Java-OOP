package lab05_polymorphism.Animals;

public class Cat extends Animal {


    public Cat(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf() + "MEEOW";
    }
}
