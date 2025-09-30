package coursemanager.controller;

import java.util.Scanner;

public class CourseController {
    private final Scanner sc = new Scanner(System.in);

    private final KhoaHocLapTrinhController lapTrinhController = new KhoaHocLapTrinhController();
    private final KhoaHocNgoaiNguController ngoaiNguController = new KhoaHocNgoaiNguController();

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== QUẢN LÝ KHÓA HỌC =====");
            System.out.println("1. Quản lý Khóa học Lập trình");
            System.out.println("2. Quản lý Khóa học Ngoại ngữ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1":
                    lapTrinhController.menuLapTrinh();
                    break;
                case "2":
                    ngoaiNguController.menuNgoaiNgu();
                    break;
                case "0":
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println(" Sai lựa chọn!");
            }
        }
    }
}