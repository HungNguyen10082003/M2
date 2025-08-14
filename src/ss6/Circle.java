package ss6;

public class Circle {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    public double getSurfaceArea() {
        return 2 * Math.PI * radius * height + 2 * getArea();
    }

    public String toString() {
        return "Cylinder[radius=" + radius + ", height=" + height + "]";
    }
}
