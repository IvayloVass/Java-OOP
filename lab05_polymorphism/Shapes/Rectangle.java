package lab05_polymorphism.Shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;

    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * (this.height + this.width));
    }

    @Override
    public void calculateArea() {
        super.setArea(this.height * this.width);
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
