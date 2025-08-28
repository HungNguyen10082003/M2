package ss8_mvc.controller;

import java.util.Scanner;

public class TeacherController {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("------------Quản lý giáo viên----------");
            System.out.println("Chức năng: " +
                    "\n 1. Danh sách" +
                    "\n 2. Thêm mới" +
                    "\n 3. Xoá" +
                    "\n 4. Tìm kiếm" +
                    "\n 5. Quay lại menu chính"
            );
            System.out.println("Chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách");
                    break;
                case 2:
                    System.out.println("Thêm mới");

                    break;
                case 3:
                    System.out.println("Xoá");
                    // code mở rộng ở đây
                    break;
                case 4:
                    System.out.println("Tìm kiếm");
                    // code mở rộng ở đây
                    break;
                default:
                    System.out.println("Đã kết thúc chương trình");
                    flag = false;
                    break;
            }
        }
    }
}