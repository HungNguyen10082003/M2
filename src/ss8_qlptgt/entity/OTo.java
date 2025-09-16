package ss8_qlptgt.entity;

public class OTo extends PhuongTienEntity {
    private int soChoNgoi;
    private String kieuXe;

    public OTo(String bks, HangSanXuat hang, int nam, String chu, int soChoNgoi, String kieuXe) {
        super(bks, hang, nam, chu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    @Override public String loai() { return "Ô TÔ"; }
    public int getSoChoNgoi() { return soChoNgoi; }
    public String getKieuXe() { return kieuXe; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Chỗ: %d | Kiểu: %s", soChoNgoi, kieuXe);
    }

    @Override
    public String getInfoToCSV() {
        // bks, hangMa, hangTen, quocGia, nam, chu, soCho, kieu
        return String.join(",",
                esc(getBienKiemSoat()),
                esc(getHang().getMa()),
                esc(getHang().getTen()),
                esc(getHang().getQuocGia()),
                String.valueOf(getNamSanXuat()),
                esc(getChuSoHuu()),
                String.valueOf(soChoNgoi),
                esc(kieuXe)
        );
    }

    public static OTo fromCSV(String[] t, HangSanXuat hang) {
        return new OTo(unesc(t[0]), hang, Integer.parseInt(t[4]), unesc(t[5]),
                Integer.parseInt(t[6]), unesc(t[7]));
    }

    // CSV helpers
    private static String esc(String s){ if(s==null)return""; if(s.contains(",")||s.contains("\"")||s.contains("\n")) return "\""+s.replace("\"","\"\"")+"\""; return s; }
    private static String unesc(String s){ s=s.trim(); if(s.startsWith("\"")&&s.endsWith("\"")) return s.substring(1,s.length()-1).replace("\"\"","\""); return s; }
}

