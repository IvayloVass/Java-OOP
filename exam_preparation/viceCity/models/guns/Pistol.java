package viceCity.models.guns;

public class Pistol extends BaseGun {

    private final static int BULLETS_PER_BARREL = 10;
    private final static int TOTAL_BULLETS = 100;


    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }


    @Override
    public int fire() {
        int currentBulletsPerBarrel = getBulletsPerBarrel() - 1;
        if (currentBulletsPerBarrel <= 0) {
            if (getTotalBullets() == 0) {
                setBulletsPerBarrel(0);
                return 0;
            } else {
                super.setTotalBullets(getTotalBullets() - 10);
                super.setBulletsPerBarrel(10);
            }
        } else {
            super.setBulletsPerBarrel(currentBulletsPerBarrel);
        }
        return 1;

    }
}
