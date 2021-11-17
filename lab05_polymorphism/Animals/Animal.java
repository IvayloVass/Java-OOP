package lab05_polymorphism.Animals;

public class Animal {
    private String name;
    private String favoriteFood;

    protected Animal(String name, String favoriteFood) {
        this.setName(name);
        this.setFavoriteFood(favoriteFood);
    }

    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s\n", this.name, this.favoriteFood);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
}
