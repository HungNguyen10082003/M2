package ss7;

public class RunColorable {
    public static void main(String[] args) {
        Object[] shapes = {
                new Square(5),
                new Rectangle(3, 4),
                new Circle(2) // Không triển khai Colorable
        };

        for (Object shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            } else {
                System.out.println("This shape cannot be colored.");
            }
            System.out.println();
        }
    }

    public static interface Colorable {
        void howToColor();
    }

    public static class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            return "Circle: radius = " + radius + ", area = " + getArea();
        }
    }

    public static class Rectangle implements Colorable {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return width * height;
        }

        @Override
        public void howToColor() {
            System.out.println("Color all four edges.");
        }

        @Override
        public String toString() {
            return "Rectangle: width = " + width + ", height = " + height + ", area = " + getArea();
        }
    }

    public static class Square implements Colorable {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getArea() {
            return side * side;
        }

        @Override
        public void howToColor() {
            System.out.println("Color all four sides.");
        }

        @Override
        public String toString() {
            return "Square: side = " + side + ", area = " + getArea();
        }
    }
}
