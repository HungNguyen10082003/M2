package ss7;

import ss7.Circle;
import ss7.Rectangle;
import ss7.Resizeable;
import ss7.Square;



public class Run {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Rectangle r = new Rectangle(4, 6);
        Square s = new Square(3);

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
}

