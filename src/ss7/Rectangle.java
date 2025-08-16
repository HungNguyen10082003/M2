package ss7;

public class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void resize(double percent) {
        width = width * (1 + percent / 100);
        height = height * (1 + percent / 100);
    }

    @Override
    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height + ", area = " + getArea();
    }
}
