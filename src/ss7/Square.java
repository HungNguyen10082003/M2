package ss7;

public class Square extends Rectangle {
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
