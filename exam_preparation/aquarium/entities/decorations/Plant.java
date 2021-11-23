package aquarium.entities.decorations;

public class Plant extends BaseDecoration {

    private static final int PLANT_COMFORT = 5;
    private static final double PLANT_PRICE = 10.0;

    public Plant() {
        super(PLANT_COMFORT, PLANT_PRICE);
    }

    public int getPLANT_COMFORT() {
        return PLANT_COMFORT;
    }

    public double getPLANT_PRICE() {
        return PLANT_PRICE;
    }
}
