package ss1;
import java.util.Scanner;

public class Exchange {public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final double tiGia = 25000;

    System.out.println("1. USD -> VND");
    System.out.println("2. VND -> USD");
    System.out.print("Chọn loại chuyển đổi: ");
    int luaChon = sc.nextInt();

    System.out.print("Nhập số tiền: ");
    double soTien = sc.nextDouble();

    if (luaChon == 1) {
        System.out.println("Kết quả: " + (soTien * tiGia) + " VND");
    } else if (luaChon == 2) {
        System.out.println("Kết quả: " + (soTien / tiGia) + " USD");
    } else {
        System.out.println("Lựa chọn không hợp lệ.");
    }
}
}
