package ss6;

public class RunCircle {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(c);
        System.out.println("Area: " + c.getArea());
        System.out.println("Perimeter: " + c.getPerimeter());

        Cylinder cy = new Cylinder(5, 10);
        System.out.println(cy);
        System.out.println("Volume: " + cy.getVolume());
        System.out.println("Surface Area: " + cy.getSurfaceArea());
    }
}
