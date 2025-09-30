package coursemanager.service;

public class KhoaHocRule {
    public static boolean ma(String s) { return s != null && s.matches("^[A-Z]{2,}-\\d{3,}$"); }
    public static boolean hocPhi(double v) { return v >= 0; }

}
