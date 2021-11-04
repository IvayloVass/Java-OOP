package lab01_abstraction.P02_PointInRectangle;

public class Point {
    private int coordinateY;
    private int coordinateX;

    public Point(int coordinateX, int getCoordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = getCoordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}
