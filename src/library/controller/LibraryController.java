package library.controller;

import java.util.Scanner;

public class LibraryController {
    private final Scanner sc = new Scanner(System.in);
    private final SachController sachController = new SachController();
    private final TapChiController tapChiController = new TapChiController();

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== MENU THƯ VIỆN =====");
            System.out.println("1. Quản lý Sách");
            System.out.println("2. Quản lý Tạp chí");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1": sachController.menuSach(); break;
                case "2": tapChiController.menuTapChi(); break;
                case "0": System.out.println("Tạm biệt!"); return;
                default: System.out.println(" Sai lựa chọn!");
            }
        }
    }
}