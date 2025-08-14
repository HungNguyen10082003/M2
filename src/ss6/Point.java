package ss6;

 public class Point {
    protected float x;
    protected float y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint() {
        super();
        this.xSpeed = 0;
        this.ySpeed = 0;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y); // Gọi constructor Point
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    public MoveablePoint move() {
        x += xSpeed;
        y += ySpeed;
        return this;
    }
    public String toString() {
        return "(" + x + ", " + y + "), speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}


