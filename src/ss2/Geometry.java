import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("CHỌN LOẠI HÌNH");
        System.out.println("1. Hình vuông");
        System.out.println("2. Hình chữ nhật");
        System.out.println("3. Hình tam giác");
        System.out.println("4. Hình tròn");
        System.out.print("Chọn (1-4): ");
        int chon = sc.nextInt();

        switch (chon) {
            case 1:
                System.out.print("Nhập cạnh a: ");
                double a = sc.nextDouble();
                System.out.println("Diện tích: " + (a * a));
                System.out.println("Chu vi: " + (4 * a));
                break;
            case 2:
                System.out.print("Nhập chiều dài: ");
                double dai = sc.nextDouble();
                System.out.print("Nhập chiều rộng: ");
                double rong = sc.nextDouble();
                System.out.println("Diện tích: " + (dai * rong));
                System.out.println("Chu vi: " + (2 * (dai + rong)));
                break;
            case 3:
                System.out.print("Nhập 3 cạnh a, b, c: ");
                double a1 = sc.nextDouble();
                double b1 = sc.nextDouble();
                double c1 = sc.nextDouble();
                double p = (a1 + b1 + c1) / 2;
                double s = Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
                System.out.println("Diện tích: " + s);
                System.out.println("Chu vi: " + (a1 + b1 + c1));
                break;
            case 4:
                System.out.print("Nhập bán kính r: ");
                double r = sc.nextDouble();
                System.out.println("Diện tích: " + (Math.PI * r * r));
                System.out.println("Chu vi: " + (2 * Math.PI * r));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }

        sc.close();
    }
}
