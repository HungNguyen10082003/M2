package library.entity;

public class SachEntity extends TaiLieuEntity {
    private int soTrang;
    private String theLoai;

    public SachEntity() {}

    public SachEntity(String ma, String ten, int nam, String tacGia, int soTrang, String theLoai) {
        super(ma, ten, nam, tacGia);
        this.soTrang = soTrang;
        this.theLoai = theLoai;
    }

    public int getSoTrang() { return soTrang; }
    public String getTheLoai() { return theLoai; }

    @Override
    public String toCsv() {
        return String.join(",", "SACH", ma, ten, String.valueOf(nam), tacGia,
                String.valueOf(soTrang), theLoai);
    }

    @Override
    public String toString() {
        return "Sach{ma='" + ma + "', ten='" + ten + "', nam=" + nam + ", tacGia='" + tacGia +
                "', soTrang=" + soTrang + ", theLoai='" + theLoai + "'}";
    }
}
