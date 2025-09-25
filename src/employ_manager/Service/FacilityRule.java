package employ_manager.Service;


public class FacilityRule {
    public static boolean area(double a) { return a >= 30; }
    public static boolean cost(double c) { return c > 0; }
    public static boolean maxPeople(int n) { return n > 0 && n <= 20; }
    public static boolean rental(String s) { return s != null && s.matches("."); }

    public static boolean codeVilla(String s) { return s != null && s.matches("^V-\\d{3,}$"); }
    public static boolean codeHouse(String s) { return s != null && s.matches("^H-\\d{3,}$"); }
    public static boolean codeRoom (String s) { return s != null && s.matches("^R-\\d{3,}$"); }
}
