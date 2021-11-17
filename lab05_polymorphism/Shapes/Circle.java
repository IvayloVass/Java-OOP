package lab05_polymorphism.Shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * Math.pow(this.radius, 2));
    }
}
