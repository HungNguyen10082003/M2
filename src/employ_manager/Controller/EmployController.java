package employ_manager.Controller;

import employ_manager.Entity.EmployeeEntity;
import employ_manager.Repository.EmployeeRepository;
import employ_manager.Service.EmployeeRule;
import employ_manager.Service.EmployeeService;
import employ_manager.Service.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployController {
    private final Scanner sc = new Scanner(System.in);
    private final IEmployeeService employeeService = new EmployeeService(new EmployeeRepository());

    private void pause() { System.out.println("Nhấn Enter để tiếp tục..."); sc.nextLine(); }

    private String inputNonEmpty(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println(">> Không được để trống!");
        }
    }

    private String inputPattern(String label, java.util.function.Predicate<String> rule, String err) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (rule.test(s)) return s;
            System.out.println(">> " + err);
        }
    }

    private double inputDouble(String label, java.util.function.DoublePredicate rule, String err) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (rule.test(v)) return v;
                System.out.println(">> " + err);
            } catch (NumberFormatException e) {
                System.out.println(">> Phải nhập số!");
            }
        }
    }

    // ====== Menu Nhân viên ======
    public void menuEmployee() {
        while (true) {
            System.out.println("\n-- QUẢN LÝ NHÂN VIÊN --");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xoá theo mã");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1":
                    List<EmployeeEntity> list = employeeService.getAll();
                    if (list.isEmpty()) System.out.println("(Chưa có dữ liệu)");
                    else list.forEach(System.out::println);
                    pause();
                    break;

                case "2":
                    try {
                        String code   = inputPattern("Mã nhân viên (EM-xxx): ",
                                EmployeeRule::code, "Mã dạng EM-xxx (ví dụ EM-001)");

                        String name   = inputNonEmpty("Họ tên: ");
                        String dob    = inputNonEmpty("Ngày sinh (dd/MM/yyyy): ");
                        String gender = inputNonEmpty("Giới tính: ");

                        String id     = inputPattern("Số CMND/CCCD (9-12 số): ",
                                EmployeeRule::idCard, "CMND/CCCD phải 9-12 chữ số");

                        String phone  = inputPattern("Số điện thoại (9-11 số): ",
                                EmployeeRule::phone, "SĐT phải 9-11 chữ số");

                        String email  = inputPattern("Email: ",
                                EmployeeRule::email, "Email không hợp lệ");

                        String level  = inputPattern(
                                "Trình độ [Trung cấp|Cao đẳng|Đại học|Sau đại học]: ",
                                EmployeeRule::level,
                                "Trình độ chỉ nhận: Trung cấp / Cao đẳng / Đại học / Sau đại học");

                        String pos    = inputPattern(
                                "Vị trí [lễ tân|phục vụ|chuyên viên|giám sát|quản lý|giám đốc]: ",
                                EmployeeRule::position,
                                "Vị trí chỉ nhận: lễ tân / phục vụ / chuyên viên / giám sát / quản lý / giám đốc");

                        double salary = inputDouble("Lương (>=0): ",
                                EmployeeRule::salary, "Lương phải >= 0");

                        employeeService.add(new EmployeeEntity(
                                code, name, dob, gender, id, phone, email, level, pos, salary
                        ));
                        System.out.println(">> Đã thêm!");
                    } catch (Exception e) {
                        System.out.println("[Lỗi] " + e.getMessage());
                    }
                    pause();
                    break;

                case "3":
                    String delCode = inputNonEmpty("Nhập mã cần xoá: ");
                    System.out.println(employeeService.removeByCode(delCode) ? ">> Đã xoá" : ">> Không tìm thấy!");
                    pause();
                    break;

                case "0":
                    return;

                default:
                    System.out.println(">> Sai lựa chọn!");
            }
        }
    }
}