package coursemanager.repository;

import coursemanager.entity.KhoaHocNgoaiNguEntity;
import coursemanager.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KhoaHocNgoaiNguRepository implements IKhoaHocRepository<KhoaHocNgoaiNguEntity> {
    private final String path = "src/coursemanager/data/ngoaingu.csv";

    @Override
    public void add(KhoaHocNgoaiNguEntity t) { ReadAndWriteFile.writeFile(path, List.of(t.toCsv()), true); }

    @Override
    public List<KhoaHocNgoaiNguEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<KhoaHocNgoaiNguEntity> rs = new ArrayList<>();
        for (String l : lines) {
            String[] a = l.split(",");
            if (a.length < 7) continue;
            rs.add(new KhoaHocNgoaiNguEntity(a[1], a[2], a[3], Double.parseDouble(a[4]), a[5], a[6]));
        }
        return rs;
    }

    @Override
    public boolean deleteByMa(String ma) {
        List<KhoaHocNgoaiNguEntity> all = findAll();
        boolean ok = all.removeIf(x -> x.getMa().equals(ma));
        if (ok) {
            List<String> out = new ArrayList<>();
            for (KhoaHocNgoaiNguEntity t : all) out.add(t.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return ok;
    }

    @Override
    public boolean existsMa(String ma) {
        return findAll().stream().anyMatch(x -> x.getMa().equals(ma));
    }

    @Override
    public List<KhoaHocNgoaiNguEntity> searchByTenLike(String keyword) {
        String k = keyword.toLowerCase(Locale.ROOT);
        List<KhoaHocNgoaiNguEntity> rs = new ArrayList<>();
        for (KhoaHocNgoaiNguEntity t : findAll())
            if (t.getTen().toLowerCase(Locale.ROOT).contains(k)) rs.add(t);
        return rs;
    }
}