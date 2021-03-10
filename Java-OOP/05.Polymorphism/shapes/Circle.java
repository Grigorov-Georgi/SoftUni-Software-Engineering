package shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        if (getPerimeter() == null) {
            setPerimeter(2 * Math.PI * radius);
        }
        return getPerimeter();
    }

    @Override
    public double calculateArea() {
        if (getArea() == null) {
            setArea(Math.PI * Math.pow(radius, 2));
        }
        return getArea();
    }
}
