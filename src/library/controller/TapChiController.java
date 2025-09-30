package library.controller;

import library.entity.TapChiEntity;
import library.repository.TapChiRepository;
import library.service.ITaiLieuService;
import library.service.TapChiService;

import java.util.List;
import java.util.Scanner;

public class TapChiController {
    private final Scanner sc = new Scanner(System.in);
    private final ITaiLieuService<TapChiEntity> tapChiService = new TapChiService(new TapChiRepository());

    private int inputInt(String label) {
        while (true) {
            System.out.print(label);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println(" Vui lòng nhập số!"); }
        }
    }

    public void menuTapChi() {
        while (true) {
            System.out.println("\n-- QUẢN LÝ TẠP CHÍ --");
            System.out.println("1. Hiển thị tất cả");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xoá theo mã");
            System.out.println("4. Tìm theo tên (gần đúng)");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1":
                    List<TapChiEntity> list = tapChiService.getAll();
                    if (list.isEmpty()) System.out.println("(Chưa có tạp chí)");
                    else list.forEach(System.out::println);
                    break;

                case "2":
                    try {
                        System.out.print("Mã (TC-xxx): "); String ma = sc.nextLine().trim();
                        System.out.print("Tên: "); String ten = sc.nextLine().trim();
                        int nam = inputInt("Năm xuất bản: ");
                        System.out.print("Tác giả/Toà soạn: "); String tg = sc.nextLine().trim();
                        int soPH = inputInt("Số phát hành (>0): ");
                        int thang = inputInt("Tháng phát hành (1..12): ");
                        tapChiService.add(new TapChiEntity(ma, ten, nam, tg, soPH, thang));
                        System.out.println(">> Đã thêm tạp chí!");
                    } catch (Exception e) { System.out.println("[Lỗi] " + e.getMessage()); }
                    break;

                case "3":
                    System.out.print("Nhập mã cần xoá: ");
                    boolean ok = tapChiService.removeByMa(sc.nextLine().trim());
                    System.out.println(ok ? "Đã xoá!" : " Không tìm thấy!");
                    break;

                case "4":
                    System.out.print("Nhập từ khoá tên: ");
                    var rs = tapChiService.searchByTenLike(sc.nextLine().trim());
                    if (rs.isEmpty()) System.out.println("(Không thấy tạp chí phù hợp)");
                    else rs.forEach(System.out::println);
                    break;

                case "0": return;
                default: System.out.println(" Sai lựa chọn!");
            }
        }
    }
}