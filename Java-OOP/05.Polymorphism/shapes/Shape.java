package shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected Double getArea() {
        return area;
    }

    protected Double getPerimeter() {
        return perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();
}
