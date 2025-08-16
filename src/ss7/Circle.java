package ss7;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }


    public void resize(double percent) {
        radius = radius * (1 + percent / 100);
    }

    @Override
    public String toString() {
        return "Circle: radius = " + radius + ", area = " + getArea();
    }
}
