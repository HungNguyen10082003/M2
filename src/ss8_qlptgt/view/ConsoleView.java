package ss8_qlptgt.view;

import ss8_qlptgt.entity.HangSanXuat;
import ss8_qlptgt.entity.PhuongTienEntity;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner sc = new Scanner(System.in);

    public int menuChinh() {
        System.out.println("\n=== CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG ===");
        System.out.println("1. Thêm mới phương tiện");
        System.out.println("2. Hiển thị phương tiện");
        System.out.println("3. Xóa phương tiện");
        System.out.println("4. Tìm kiếm theo biển kiểm soát");
        System.out.println("5. Thêm/Cập nhật hãng sản xuất");
        System.out.println("6. Thoát");
        System.out.print("Chọn: ");
        return readInt();
    }

    public int menuThem() {
        System.out.println("\n1. Thêm xe tải");
        System.out.println("2. Thêm ôtô");
        System.out.println("3. Thêm xe máy");
        System.out.print("Chọn: ");
        return readInt();
    }

    public int menuHienThi() {
        System.out.println("\n1. Hiển thị xe tải");
        System.out.println("2. Hiển thị ôtô");
        System.out.println("3. Hiển thị xe máy");
        System.out.print("Chọn: ");
        return readInt();
    }

    public String input(String label) {
        System.out.print(label + ": ");
        return sc.nextLine().trim();
    }

    public int readInt() {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) { System.out.print("Nhập số hợp lệ: "); }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Double.parseDouble(s);
            } catch (Exception e) { System.out.print("Nhập số thực hợp lệ: "); }
        }
    }

    public void chonHang(List<HangSanXuat> hangs) {
        System.out.println("\nChọn hãng sản xuất:");
        for (int i = 0; i < hangs.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, hangs.get(i));
        }
        System.out.print("Chọn (1-" + hangs.size() + "): ");
    }

    public void inDanhSach(List<? extends PhuongTienEntity> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("(Danh sách trống)");
            return;
        }
        list.forEach(System.out::println);
    }
}