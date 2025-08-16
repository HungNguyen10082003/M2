package ss7;


public class RunResizeable {
    public static void main(String[] args) {
        Rectangle.Circle c = new Rectangle.Circle(5);
        Rectangle r = new Rectangle(4, 6);
        Rectangle.Square s = new Rectangle.Square(3);

        System.out.println("Trước khi resize:");
        System.out.println(c);
        System.out.println(r);
        System.out.println(s);

        c.resize(20);
        r.resize(50);
        s.resize(100);

        System.out.println("\nSau khi resize:");
        System.out.println(c);
        System.out.println(r);
        System.out.println(s);
    }

    public static class Rectangle {
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

        public static class Circle {
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

        public static interface Resizeable {
            void resize(double percent);
        }

        public static class Square extends Rectangle {
            public Square(double side) {
                super(side, side);
            }

            @Override
            public void resize(double percent) {
                width = width * (1 + percent / 100);
                height = width;
            }

            @Override
            public String toString() {
                return "Square: side = " + width + ", area = " + getArea();
            }
        }
    }
}

