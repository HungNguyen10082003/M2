package ss8_qlptgt.entity;

public class XeMay extends PhuongTienEntity {
    private int congSuat;

    public XeMay(String bks, HangSanXuat hang, int nam, String chu, int congSuat) {
        super(bks, hang, nam, chu);
        this.congSuat = congSuat;
    }

    @Override public String loai() { return "XE MÁY"; }
    public int getCongSuat() { return congSuat; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Công suất: %d", congSuat);
    }

    @Override
    public String getInfoToCSV() {
        // bks, hangMa, hangTen, quocGia, nam, chu, congSuat
        return String.join(",",
                esc(getBienKiemSoat()),
                esc(getHang().getMa()),
                esc(getHang().getTen()),
                esc(getHang().getQuocGia()),
                String.valueOf(getNamSanXuat()),
                esc(getChuSoHuu()),
                String.valueOf(congSuat)
        );
    }

    public static XeMay fromCSV(String[] t, HangSanXuat hang) {
        return new XeMay(unesc(t[0]), hang, Integer.parseInt(t[4]), unesc(t[5]),
                Integer.parseInt(t[6]));
    }

    private static String esc(String s){ if(s==null)return""; if(s.contains(",")||s.contains("\"")||s.contains("\n")) return "\""+s.replace("\"","\"\"")+"\""; return s; }
    private static String unesc(String s){ s=s.trim(); if(s.startsWith("\"")&&s.endsWith("\"")) return s.substring(1,s.length()-1).replace("\"\"","\""); return s; }
}