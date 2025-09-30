package library.entity;

public abstract class TaiLieuEntity {
    protected String ma;
    protected String ten;
    protected int nam;
    protected String tacGia;

    public TaiLieuEntity() {}

    public TaiLieuEntity(String ma, String ten, int nam, String tacGia) {
        this.ma = ma;
        this.ten = ten;
        this.nam = nam;
        this.tacGia = tacGia;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public int getNam() { return nam; }
    public String getTacGia() { return tacGia; }

    public abstract String toCsv();

    @Override
    public String toString() {
        return "TaiLieu{ma='" + ma + "', ten='" + ten + "', nam=" + nam + ", tacGia='" + tacGia + "'}";
    }
}
