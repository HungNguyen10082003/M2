package library.entity;

public class TapChiEntity extends TaiLieuEntity {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChiEntity() {}

    public TapChiEntity(String ma, String ten, int nam, String tacGia, int soPhatHanh, int thangPhatHanh) {
        super(ma, ten, nam, tacGia);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getSoPhatHanh() { return soPhatHanh; }
    public int getThangPhatHanh() { return thangPhatHanh; }

    @Override
    public String toCsv() {
        return String.join(",", "TAPCHI", ma, ten, String.valueOf(nam), tacGia,
                String.valueOf(soPhatHanh), String.valueOf(thangPhatHanh));
    }

    @Override
    public String toString() {
        return "TapChi{ma='" + ma + "', ten='" + ten + "', nam=" + nam + ", tacGia='" + tacGia +
                "', soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + "}";
    }
}
