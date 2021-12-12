package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 7;
    private static final int KILOGRAMS_INCREASES = 1;


    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(getKilograms() + KILOGRAMS_INCREASES);

    }
}
