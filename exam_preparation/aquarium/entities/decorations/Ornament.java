package aquarium.entities.decorations;

public class Ornament extends BaseDecoration {

    private static final int ORNAMENT_COMFORT = 1;
    private static final double ORNAMENT_PRICE = 5.0;


    public Ornament() {
        super(ORNAMENT_COMFORT, ORNAMENT_PRICE);
    }

    @Override
    public int getComfort() {
        return ORNAMENT_COMFORT;
    }

    @Override
    public double getPrice() {
        return ORNAMENT_PRICE;
    }
}
