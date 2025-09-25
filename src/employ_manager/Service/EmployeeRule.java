package employ_manager.Service;

import java.util.Set;

public class EmployeeRule {
    private static final Set<String> LEVELS = Set.of("Trung cấp","Cao đẳng","Đại học","Sau đại học");
    private static final Set<String> POSITIONS = Set.of("lễ tân","phục vụ","chuyên viên","giám sát","quản lý","giám đốc");

    public static boolean code(String s) { return s != null && s.matches("^EM-\\d{3,}$"); } // ví dụ EM-001
    public static boolean phone(String s) { return s != null && s.matches("^\\d{9,11}$"); }
    public static boolean idCard(String s) { return s != null && s.matches("^\\d{9,12}$"); }
    public static boolean email(String s) { return s != null && s.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"); }
    public static boolean level(String s) { return s != null && LEVELS.contains(s); }
    public static boolean position(String s) { return s != null && POSITIONS.contains(s); }
    public static boolean salary(double d) { return d >= 0; }
}