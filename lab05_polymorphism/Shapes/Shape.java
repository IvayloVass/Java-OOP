package lab05_polymorphism.Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();


    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        calculatePerimeter();
        return perimeter;
    }

    public Double getArea() {
        calculateArea();
        return area;
    }
}
