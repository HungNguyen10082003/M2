package ss6;

public class RunPoint {
    public static void main(String[] args) {
        Point2D p2 = new Point2D(3, 4);
        System.out.println("Point2D: " + p2);

        Point3D p3 = new Point3D(1, 2, 3);
        System.out.println("Point3D: " + p3);

        p3.setXYZ(7, 8, 9);
        System.out.println("Point3D after setXYZ: " + p3);
    }
}
