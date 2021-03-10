package shapes;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculatePerimeter() {
        if (getPerimeter() == null) {
            setPerimeter(2 * width + 2 * height);
        }
        return getPerimeter();
    }

    @Override
    public double calculateArea() {
        if (getArea() == null){
            setArea(width * height);
        }
        return getArea();
    }
}
