package ss8_qlptgt.entity;

public class HangSanXuat {
    private String ma;
    private String ten;
    private String quocGia;

    public HangSanXuat(String ma, String ten, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.quocGia = quocGia;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public String getQuocGia() { return quocGia; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s", ma, ten, quocGia);
    }

    public String toCSV() {
        return String.join(",", esc(ma), esc(ten), esc(quocGia));
    }

    public static HangSanXuat fromCSV(String[] t) {
        return new HangSanXuat(unesc(t[0]), unesc(t[1]), unesc(t[2]));
    }

    private static String esc(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n"))
            return "\"" + s.replace("\"", "\"\"") + "\"";
        return s;
    }
    private static String unesc(String s) {
        s = s.trim();
        if (s.startsWith("\"") && s.endsWith("\""))
            return s.substring(1, s.length()-1).replace("\"\"", "\"");
        return s;
    }
}