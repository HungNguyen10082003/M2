package ss8_mvc.controller;

import java.util.Scanner;
import ss8_mvc.controller.StudentController;

public class MainController {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("------------Chọn chức năng quản ly----------");
            System.out.println("Chức năng: " +
                    "\n 1. Quản lý sinh viên" +
                    "\n 2. Quản lý giáo viên" +
                    "\n 5. Thoát"
            );
            System.out.println("Chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Chức năng quản lý sinh viên");
                    ss8_mvc.controller.StudentController.displayMenu();
                    break;
                case 2:
                    System.out.println("Chức năng quản lý giáo viên");
                    TeacherController.displayMenu();
                    break;
                default:
                    System.out.println("Đã kết thúc chương trình");
                    flag = false;
                    break;
            }
        }
    }
}