package coursemanager.entity;

public abstract class KhoaHocEntity {
    protected String ma;
    protected String ten;
    protected String giangVien;
    protected double hocPhi;
    public KhoaHocEntity() {}

    public KhoaHocEntity(String ma, String ten, String giangVien, double hocPhi) {
        this.ma = ma; this.ten = ten; this.giangVien = giangVien; this.hocPhi = hocPhi;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public String getGiangVien() { return giangVien; }
    public double getHocPhi() { return hocPhi; }

    public abstract String toCsv();

    @Override
    public String toString() {
        return "KhoaHoc{ma='" + ma + "', ten='" + ten + "', giangVien='" + giangVien + "', hocPhi=" + hocPhi + "}";
    }
}