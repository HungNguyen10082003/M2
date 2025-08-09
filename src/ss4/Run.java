package ss4;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập c: ");
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double getDiscriminant = equation.getDiscriminant();

        if (getDiscriminant > 0) {
            System.out.println("Phương trình có 2 nghiệm:");
            System.out.println("Nghiệm 1: " + equation.getRoot1());
            System.out.println("Nghiệm 2: " + equation.getRoot2());
        } else if (getDiscriminant == 0) {
            System.out.println("Phương trình có nghiệm kép:");
            System.out.println("Nghiệm: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}