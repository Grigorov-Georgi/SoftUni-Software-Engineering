package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isPositiveORBiggerThanZero(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (isPositiveORBiggerThanZero(width)) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (isPositiveORBiggerThanZero(height)) {
            this.height = height;
        }
    }

    private boolean isPositiveORBiggerThanZero(double number) {
        if (number <= 0) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }
        return true;
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width +
                2 * this.length * this.height +
                2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.height * this.width +
                2 * this.length * this.height;
    }

    public double calculateVolume() {
        return this.height * this.length * this.width;
    }
}
