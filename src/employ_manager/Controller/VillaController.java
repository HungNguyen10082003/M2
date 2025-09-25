package employ_manager.Controller;

import employ_manager.Entity.VillaEntity;
import employ_manager.Repository.VillaRepository;
import employ_manager.Service.VillaService;
import employ_manager.Service.IFacilityService;

import java.util.List;
import java.util.Scanner;

public class VillaController {
    private final Scanner sc = new Scanner(System.in);
    private final IFacilityService<VillaEntity> villaService =
            new VillaService(new VillaRepository());

    private void pause() { System.out.println("Nhấn Enter để tiếp tục"); sc.nextLine(); }

    public void menuVilla() {
        while (true) {
            System.out.println("\n-- QUẢN LÝ VILLA --");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xoá theo mã");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine();
            switch (c) {
                case "1":
                    List<VillaEntity> list = villaService.getAll();
                    if (list.isEmpty()) System.out.println("(Chưa có dữ liệu)");
                    else list.forEach(System.out::println);
                    pause();
                    break;
                case "2":
                    try {
                        System.out.print("Mã (V-xxx): "); String code = sc.nextLine();
                        System.out.print("Tên dịch vụ: "); String name = sc.nextLine();
                        System.out.print("Diện tích (>=30): "); double area = Double.parseDouble(sc.nextLine());
                        System.out.print("Chi phí (>0): "); double cost = Double.parseDouble(sc.nextLine());
                        System.out.print("Số người tối đa (1-20): "); int max = Integer.parseInt(sc.nextLine());
                        System.out.print("Kiểu thuê (year|month|day|hour): "); String rental = sc.nextLine();
                        System.out.print("Tiêu chuẩn phòng: "); String std = sc.nextLine();
                        System.out.print("Diện tích hồ bơi: "); double pool = Double.parseDouble(sc.nextLine());
                        System.out.print("Số tầng: "); int floors = Integer.parseInt(sc.nextLine());
                        villaService.add(new VillaEntity(code, name, area, cost, max, rental, std, pool, floors));
                        System.out.println(">> Đã thêm!");
                    } catch (Exception e) { System.out.println("[Lỗi] " + e.getMessage()); }
                    pause();
                    break;
                case "3":
                    System.out.print("Nhập mã cần xoá: ");
                    System.out.println(villaService.removeByCode(sc.nextLine()) ? " Đã xoá" : " Không tìm thấy!");
                    pause();
                    break;
                case "0": return;
                default: System.out.println(" Sai lựa chọn!");
            }
        }
    }
}
