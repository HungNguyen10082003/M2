package coursemanager.controller;

import coursemanager.entity.KhoaHocLapTrinhEntity;
import coursemanager.repository.KhoaHocLapTrinhRepository;
import coursemanager.service.IKhoaHocService;
import coursemanager.service.KhoaHocLapTrinhService;

import java.util.List;
import java.util.Scanner;

public class KhoaHocLapTrinhController {
    private final Scanner sc = new Scanner(System.in);
    private final IKhoaHocService<KhoaHocLapTrinhEntity> service =
            new KhoaHocLapTrinhService(new KhoaHocLapTrinhRepository());

    private double inputDouble(String label) {
        while (true) {
            System.out.print(label);
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println(">> Vui lòng nhập số!"); }
        }
    }

    public void menuLapTrinh() {
        while (true) {
            System.out.println("\n-- KHÓA HỌC LẬP TRÌNH --");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Xoá theo mã");
            System.out.println("4. Tìm theo tên (gần đúng)");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1":
                    List<KhoaHocLapTrinhEntity> list = service.getAll();
                    if (list.isEmpty()) System.out.println("(Chưa có dữ liệu)");
                    else list.forEach(System.out::println);
                    break;

                case "2":
                    try {
                        System.out.print("Mã (VD KH-001): "); String ma = sc.nextLine().trim();
                        System.out.print("Tên khoá học: "); String ten = sc.nextLine().trim();
                        System.out.print("Giảng viên: "); String gv = sc.nextLine().trim();
                        double hp = inputDouble("Học phí (>=0): ");
                        System.out.print("Ngôn ngữ lập trình chính: "); String lang = sc.nextLine().trim();
                        service.add(new KhoaHocLapTrinhEntity(ma, ten, gv, hp, lang));
                        System.out.println(">> Đã thêm!");
                    } catch (Exception e) { System.out.println("[Lỗi] " + e.getMessage()); }
                    break;

                case "3":
                    System.out.print("Nhập mã cần xoá: ");
                    System.out.println(service.removeByMa(sc.nextLine().trim()) ? ">> Đã xoá" : ">> Không tìm thấy!");
                    break;

                case "4":
                    System.out.print("Nhập từ khoá tên: ");
                    var rs = service.searchByTenLike(sc.nextLine().trim());
                    if (rs.isEmpty()) System.out.println("(Không thấy khoá phù hợp)");
                    else rs.forEach(System.out::println);
                    break;

                case "0": return;
                default: System.out.println(">> Sai lựa chọn!");
            }
        }
    }
}
