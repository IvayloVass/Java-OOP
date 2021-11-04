package lab01_abstraction.P02_PointInRectangle;

public class Rectangle {
    private Point A;
    private Point B;

    public Rectangle(Point a, Point b) {
        A = a;
        B = b;
    }

    public boolean contains(Point point) {
        return A.getCoordinateX() <= point.getCoordinateX() && A.getCoordinateY() <= point.getCoordinateY()
                && point.getCoordinateX() <= B.getCoordinateX() && point.getCoordinateY() <= B.getCoordinateY();
    }
}
