package coursemanager.entity;

public class KhoaHocNgoaiNguEntity extends KhoaHocEntity {
    private String ngonNguDay;
    private String capDo;

    public KhoaHocNgoaiNguEntity() {}

    public KhoaHocNgoaiNguEntity(String ma, String ten, String giangVien, double hocPhi, String ngonNguDay, String capDo) {
        super(ma, ten, giangVien, hocPhi);
        this.ngonNguDay = ngonNguDay; this.capDo = capDo;
    }

    public String getNgonNguDay() { return ngonNguDay; }
    public String getCapDo() { return capDo; }

    @Override
    public String toCsv() {
        return String.join(",", "NGOAINGU", ma, ten, giangVien, String.valueOf(hocPhi), ngonNguDay, capDo);
    }

    @Override
    public String toString() {
        return "NgoaiNgu{ma='" + ma + "', ten='" + ten + "', giangVien='" + giangVien +
                "', hocPhi=" + hocPhi + ", ngonNguDay='" + ngonNguDay + "', capDo='" + capDo + "'}";
    }
}
