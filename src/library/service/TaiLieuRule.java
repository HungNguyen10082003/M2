package library.service;

public class TaiLieuRule {
    public static boolean ma(String s) { return s != null && s.matches("^[A-Z]{2,}-\\d{3,}$"); }
    public static boolean nam(int y) { return y >= 1800 && y <= 2100; }
    public static boolean thang(int m) { return m >= 1 && m <= 12; }
    public static boolean soDuong(int n) { return n > 0; }
}