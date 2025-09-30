package library.controller;

import library.entity.SachEntity;
import library.repository.SachRepository;
import library.service.ITaiLieuService;
import library.service.SachService;

import java.util.List;
import java.util.Scanner;

public class SachController {
    private final Scanner sc = new Scanner(System.in);
    private final ITaiLieuService<SachEntity> sachService = new SachService(new SachRepository());

    private int inputInt(String label) {
        while (true) {
            System.out.print(label);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println(">> Vui lòng nhập số!"); }
        }
    }

    public void menuSach() {
        while (true) {
            System.out.println("\n-- QUẢN LÝ SÁCH --");
            System.out.println("1. Hiển thị tất cả");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xoá theo mã");
            System.out.println("4. Tìm theo tên (gần đúng)");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1":
                    List<SachEntity> list = sachService.getAll();
                    if (list.isEmpty()) System.out.println("(Chưa có sách)");
                    else list.forEach(System.out::println);
                    break;

                case "2":
                    try {
                        System.out.print("Mã (SA-xxx): "); String ma = sc.nextLine().trim();
                        System.out.print("Tên: "); String ten = sc.nextLine().trim();
                        int nam = inputInt("Năm xuất bản ");
                        System.out.print("Tác giả: "); String tg = sc.nextLine().trim();
                        int soTrang = inputInt("Số trang (>0): ");
                        System.out.print("Thể loại: "); String tl = sc.nextLine().trim();
                        sachService.add(new SachEntity(ma, ten, nam, tg, soTrang, tl));
                        System.out.println(" Đã thêm sách!");
                    } catch (Exception e) { System.out.println("[Lỗi] " + e.getMessage()); }
                    break;

                case "3":
                    System.out.print("Nhập mã cần xoá: ");
                    boolean ok = sachService.removeByMa(sc.nextLine().trim());
                    System.out.println(ok ? " Đã xoá!" : " Không tìm thấy!");
                    break;

                case "4":
                    System.out.print("Nhập từ khoá tên: ");
                    var rs = sachService.searchByTenLike(sc.nextLine().trim());
                    if (rs.isEmpty()) System.out.println("(Không thấy sách phù hợp)");
                    else rs.forEach(System.out::println);
                    break;

                case "0": return;
                default: System.out.println(" Sai lựa chọn!");
            }
        }
    }
}