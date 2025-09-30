package coursemanager.repository;

import coursemanager.entity.KhoaHocLapTrinhEntity;
import coursemanager.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KhoaHocLapTrinhRepository implements IKhoaHocRepository<KhoaHocLapTrinhEntity> {
    private final String path = "src/coursemanager/data/laptrinh.csv";

    @Override
    public void add(KhoaHocLapTrinhEntity t) { ReadAndWriteFile.writeFile(path, List.of(t.toCsv()), true); }

    @Override
    public List<KhoaHocLapTrinhEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<KhoaHocLapTrinhEntity> rs = new ArrayList<>();
        for (String l : lines) {
            String[] a = l.split(",");
            if (a.length < 6) continue;
            rs.add(new KhoaHocLapTrinhEntity(a[1], a[2], a[3], Double.parseDouble(a[4]), a[5]));
        }
        return rs;
    }

    @Override
    public boolean deleteByMa(String ma) {
        List<KhoaHocLapTrinhEntity> all = findAll();
        boolean ok = all.removeIf(x -> x.getMa().equals(ma));
        if (ok) {
            List<String> out = new ArrayList<>();
            for (KhoaHocLapTrinhEntity t : all) out.add(t.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return ok;
    }

    @Override
    public boolean existsMa(String ma) {
        return findAll().stream().anyMatch(x -> x.getMa().equals(ma));
    }

    @Override
    public List<KhoaHocLapTrinhEntity> searchByTenLike(String keyword) {
        String k = keyword.toLowerCase(Locale.ROOT);
        List<KhoaHocLapTrinhEntity> rs = new ArrayList<>();
        for (KhoaHocLapTrinhEntity t : findAll())
            if (t.getTen().toLowerCase(Locale.ROOT).contains(k)) rs.add(t);
        return rs;
    }
}
