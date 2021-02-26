package PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Rectangle(int[] array) {
        Point first = new Point(array[0], array[1]);
        Point second = new Point(array[2], array[3]);
        this.bottomLeft = first;
        this.topRight = second;
    }

    public boolean contains(int[] array){
        Point point = new Point(array[0], array[1]);
        return biggerThanLowerX(point) &&
                biggerThanLowerY(point) &&
                lowerThanUpperX(point) &&
                lowerThanUpperY(point);
    }
    public boolean biggerThanLowerX(Point point){
        return bottomLeft.getX() <= point.getX();
    }
    public boolean biggerThanLowerY(Point point){
        return bottomLeft.getY() <= point.getY();
    }
    public boolean lowerThanUpperX(Point point){
        return topRight.getX() >= point.getX();
    }
    public boolean lowerThanUpperY(Point point){
        return topRight.getY() >= point.getY();
    }
}
