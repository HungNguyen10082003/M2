package ss5;

public class RunCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.getArea());

        Circle c2 = new Circle(2.5);
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Area: " + c2.getArea());
    }
}
