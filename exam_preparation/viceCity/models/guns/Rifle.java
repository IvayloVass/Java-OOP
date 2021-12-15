package viceCity.models.guns;

public class Rifle extends BaseGun {
    private final static int BULLETS_PER_BARREL = 50;
    private final static int TOTAL_BULLETS = 500;


    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        int currentBulletsPerBarrel = getBulletsPerBarrel() - 5;
        if (currentBulletsPerBarrel <= 0) {
            if (getTotalBullets() == 0) {
                setBulletsPerBarrel(0);
                return 0;
            } else {
                super.setTotalBullets(getTotalBullets() - 50);
                super.setBulletsPerBarrel(50);
            }
        } else {
            super.setBulletsPerBarrel(currentBulletsPerBarrel);
        }
        return 5;

    }
}
