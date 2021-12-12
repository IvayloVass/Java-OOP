package catHouse.entities.houses;

import catHouse.entities.cat.Cat;

public class ShortHouse extends BaseHouse {

    public static final int CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addCat(Cat cat) {
        if (getClass().getSimpleName().equals("LongHouse") && cat.getClass().getSimpleName().equals("LonghairCat")) {
            super.addCat(cat);
        } else if (getClass().getSimpleName().equals("ShortHouse") && cat.getClass().getSimpleName().equals("ShorthairCat")) {
            super.addCat(cat);

        }
    }
}
