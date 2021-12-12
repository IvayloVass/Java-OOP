package catHouse.entities.houses;

import catHouse.entities.cat.Cat;

import static catHouse.common.ConstantMessages.UNSUITABLE_HOUSE;

public class LongHouse extends BaseHouse {

    public static final int CAPACITY = 30;

    public LongHouse(String name) {
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
