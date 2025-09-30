package coursemanager.entity;

public class KhoaHocLapTrinhEntity extends KhoaHocEntity {
    private String ngonNguChinh;

    public KhoaHocLapTrinhEntity() {}

    public KhoaHocLapTrinhEntity(String ma, String ten, String giangVien, double hocPhi, String ngonNguChinh) {
        super(ma, ten, giangVien, hocPhi);
        this.ngonNguChinh = ngonNguChinh;
    }

    public String getNgonNguChinh() { return ngonNguChinh; }

    @Override
    public String toCsv() {
        return String.join(",", "LAPTRINH", ma, ten, giangVien, String.valueOf(hocPhi), ngonNguChinh);
    }

    @Override
    public String toString() {
        return "LapTrinh{ma='" + ma + "', ten='" + ten + "', giangVien='" + giangVien +
                "', hocPhi=" + hocPhi + ", ngonNguChinh='" + ngonNguChinh + "'}";
    }
}