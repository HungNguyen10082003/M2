package ss6;

public class RunMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint mp = new MoveablePoint(2, 3, 1, 1);
        System.out.println("Before move: " + mp);
        mp.move();
        System.out.println("After move: " + mp);
    }
}

