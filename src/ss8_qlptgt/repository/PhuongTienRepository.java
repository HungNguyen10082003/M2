package ss8_qlptgt.repository;
import ss8_qlptgt.util.ReadAndWrite;
import ss8_qlptgt.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhuongTienRepository implements IPhuongTienRepository {

    private final List<HangSanXuat> hangSanXuat = new ArrayList<>();
    private final List<XeTai> xeTai = new ArrayList<>();
    private final List<OTo> oTo = new ArrayList<>();
    private final List<XeMay> xeMay = new ArrayList<>();

    private final String DATA_DIR = "data";
    private final String HANG_FILE = DATA_DIR + "/hang_sx.csv";
    private final String XE_TAI_FILE = DATA_DIR + "/xe_tai.csv";
    private final String O_TO_FILE   = DATA_DIR + "/o_to.csv";
    private final String XE_MAY_FILE = DATA_DIR + "/xe_may.csv";

    public PhuongTienRepository() {
        // có thể seed mặc định sau khi load nếu rỗng
    }

    // ---------- HANG ----------

    @Override public List<HangSanXuat> getHangSanXuat() { return hangSanXuat; }

    @Override public HangSanXuat findHangByIndex(int index) {
        if (index < 0 || index >= hangSanXuat.size()) return null;
        return hangSanXuat.get(index);
    }

    @Override public void upsertHang(HangSanXuat h) {
        for (int i = 0; i < hangSanXuat.size(); i++) {
            if (hangSanXuat.get(i).getMa().equalsIgnoreCase(h.getMa())) {
                hangSanXuat.set(i, h); return;
            }
        }
        hangSanXuat.add(h);
    }

    // ---------- ADD ----------

    @Override public void addXeTai(XeTai x) { xeTai.add(x); upsertHang(x.getHang()); }
    @Override public void addOTo(OTo x)     { oTo.add(x);   upsertHang(x.getHang()); }
    @Override public void addXeMay(XeMay x) { xeMay.add(x); upsertHang(x.getHang()); }

    // ---------- GET LIST ----------

    @Override public List<XeTai> getXeTai() { return xeTai; }
    @Override public List<OTo> getOTo() { return oTo; }
    @Override public List<XeMay> getXeMay() { return xeMay; }

    // ---------- DELETE ----------

    @Override
    public boolean deleteByBks(String bks) {
        boolean a = xeTai.removeIf(x -> x.getBienKiemSoat().equalsIgnoreCase(bks));
        boolean b = oTo.removeIf(x -> x.getBienKiemSoat().equalsIgnoreCase(bks));
        boolean c = xeMay.removeIf(x -> x.getBienKiemSoat().equalsIgnoreCase(bks));
        return a || b || c;
    }

    // ---------- SEARCH ----------

    @Override
    public List<PhuongTienEntity> searchLikeBks(String keyword) {
        String k = keyword.toLowerCase();
        List<PhuongTienEntity> rs = new ArrayList<>();
        rs.addAll(xeTai.stream().filter(x -> x.getBienKiemSoat().toLowerCase().contains(k)).collect(Collectors.toList()));
        rs.addAll(oTo.stream().filter(x -> x.getBienKiemSoat().toLowerCase().contains(k)).collect(Collectors.toList()));
        rs.addAll(xeMay.stream().filter(x -> x.getBienKiemSoat().toLowerCase().contains(k)).collect(Collectors.toList()));
        return rs;
    }

    // ---------- IO ----------

    @Override
    public void loadFromDisk() throws Exception {
        // Hãng
        hangSanXuat.clear();
        for (String line : ReadAndWrite.readFileCSV(HANG_FILE)) {
            String[] t = ReadAndWrite.splitCsvSmart(line, 3);
            hangSanXuat.add(HangSanXuat.fromCSV(t));
        }
        if (hangSanXuat.isEmpty()) {
            hangSanXuat.addAll(List.of(
                    new HangSanXuat("H01", "Toyota", "Nhật Bản"),
                    new HangSanXuat("H02", "Hyundai", "Hàn Quốc"),
                    new HangSanXuat("H03", "Ford", "Mỹ"),
                    new HangSanXuat("H04", "VinFast", "Việt Nam"),
                    new HangSanXuat("H05", "Honda", "Nhật Bản")
            ));
        }

        Map<String, HangSanXuat> hangByMa = hangSanXuat.stream()
                .collect(Collectors.toMap(HangSanXuat::getMa, h -> h, (a, b)->a));

        // Xe tải
        xeTai.clear();
        for (String line : ReadAndWrite.readFileCSV(XE_TAI_FILE)) {
            String[] t = ReadAndWrite.splitCsvSmart(line, 7);
            String ma = unesc(t[1]), ten = unesc(t[2]), qg = unesc(t[3]);
            HangSanXuat hang = hangByMa.computeIfAbsent(ma, m -> new HangSanXuat(ma, ten, qg));
            xeTai.add(XeTai.fromCSV(t, hang));
        }
        // Ô tô
        oTo.clear();
        for (String line : ReadAndWrite.readFileCSV(O_TO_FILE)) {
            String[] t = ReadAndWrite.splitCsvSmart(line,7);
            String ma = unesc(t[1]), ten = unesc(t[2]), qg = unesc(t[3]);
            HangSanXuat hang = hangByMa.computeIfAbsent(ma, m -> new HangSanXuat(ma, ten, qg));
            oTo.add(OTo.fromCSV(t, hang));
        }
        // Xe máy
        xeMay.clear();
        for (String line : ReadAndWrite.readFileCSV(XE_MAY_FILE)) {
            String[] t = ReadAndWrite.splitCsvSmart(line, 7);
            String ma = unesc(t[1]), ten = unesc(t[2]), qg = unesc(t[3]);
            HangSanXuat hang = hangByMa.computeIfAbsent(ma, m -> new HangSanXuat(ma, ten, qg));
            xeMay.add(XeMay.fromCSV(t, hang));
        }
    }

    @Override
    public void saveToDisk() throws Exception {
        // Hãng
        ReadAndWrite.writeListStringToCSV(HANG_FILE,
                hangSanXuat.stream().map(HangSanXuat::toCSV).collect(Collectors.toList()),
                false);

        // Xe tải
        ReadAndWrite.writeListStringToCSV(XE_TAI_FILE,
                xeTai.stream().map(XeTai::getInfoToCSV).collect(Collectors.toList()),
                false);

        // Ô tô
        ReadAndWrite.writeListStringToCSV(O_TO_FILE,
                oTo.stream().map(OTo::getInfoToCSV).collect(Collectors.toList()),
                false);

        // Xe máy
        ReadAndWrite.writeListStringToCSV(XE_MAY_FILE,
                xeMay.stream().map(XeMay::getInfoToCSV).collect(Collectors.toList()),
                false);
    }

    // unesc đơn giản tái sử dụng
    private static String unesc(String s){
        s = s.trim();
        if (s.startsWith("\"") && s.endsWith("\""))
            return s.substring(1, s.length()-1).replace("\"\"", "\"");
        return s;
    }}
