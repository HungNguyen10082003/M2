package ss8_qlptgt.entity;

import java.util.Objects;

public abstract class PhuongTienEntity {
    private String bienKiemSoat;
    private HangSanXuat hang;
    private int namSanXuat;
    private String chuSoHuu;

    public PhuongTienEntity(String bienKiemSoat, HangSanXuat hang, int namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.hang = hang;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() { return bienKiemSoat; }
    public HangSanXuat getHang() { return hang; }
    public int getNamSanXuat() { return namSanXuat; }
    public String getChuSoHuu() { return chuSoHuu; }

    public abstract String loai();

    /** Mỗi subclass tự override -> 1 dòng CSV */
    public abstract String getInfoToCSV();

    @Override
    public String toString() {
        return String.format("%s | BKS: %s | Hãng: %s | Năm: %d | Chủ: %s",
                loai(), bienKiemSoat, hang.getTen(), namSanXuat, chuSoHuu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhuongTienEntity)) return false;
        PhuongTienEntity that = (PhuongTienEntity) o;
        return Objects.equals(bienKiemSoat, that.bienKiemSoat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bienKiemSoat);
    }
}
