package ss8_qlptgt.entity;

public class XeTai extends PhuongTienEntity {
    private double trongTai;

    public XeTai(String bks, HangSanXuat hang, int nam, String chu, double trongTai) {
        super(bks, hang, nam, chu);
        this.trongTai = trongTai;
    }

    @Override public String loai() { return "XE TẢI"; }
    public double getTrongTai() { return trongTai; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Trọng tải: %.2f t", trongTai);
    }

    @Override
    public String getInfoToCSV() {
        // bks, hangMa, hangTen, quocGia, nam, chu, trongTai
        return String.join(",",
                esc(getBienKiemSoat()),
                esc(getHang().getMa()),
                esc(getHang().getTen()),
                esc(getHang().getQuocGia()),
                String.valueOf(getNamSanXuat()),
                esc(getChuSoHuu()),
                String.valueOf(trongTai)
        );
    }

    public static XeTai fromCSV(String[] t, HangSanXuat hang) {
        return new XeTai(unesc(t[0]), hang, Integer.parseInt(t[4]), unesc(t[5]),
                Double.parseDouble(t[6]));
    }

    private static String esc(String s){ if(s==null)return""; if(s.contains(",")||s.contains("\"")||s.contains("\n")) return "\""+s.replace("\"","\"\"")+"\""; return s; }
    private static String unesc(String s){ s=s.trim(); if(s.startsWith("\"")&&s.endsWith("\"")) return s.substring(1,s.length()-1).replace("\"\"","\""); return s; }
}
