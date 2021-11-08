package lab03_inheritance.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int size = super.size();
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        return super.remove(randomIndex);
    }
}
