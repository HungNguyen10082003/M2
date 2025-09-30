package library.repository;

import library.entity.SachEntity;
import library.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SachRepository implements ITaiLieuRepository<SachEntity> {
    private final String path = "src/library/data/sach.csv";

    @Override
    public List<SachEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<SachEntity> rs = new ArrayList<>();
        for (String l : lines) {
            String[] a = l.split(",");
            if (a.length < 7) continue;
            rs.add(new SachEntity(a[1], a[2], Integer.parseInt(a[3]), a[4],
                    Integer.parseInt(a[5]), a[6]));
        }
        return rs;
    }

    @Override public void add(SachEntity s) { ReadAndWriteFile.writeFile(path, List.of(s.toCsv()), true); }

    @Override public boolean deleteByMa(String ma) {
        List<SachEntity> all = findAll();
        boolean ok = all.removeIf(x -> x.getMa().equals(ma));
        if (ok) {
            List<String> out = new ArrayList<>();
            for (SachEntity s : all) out.add(s.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return ok;
    }

    @Override public boolean existsMa(String ma) { return findAll().stream().anyMatch(x -> x.getMa().equals(ma)); }

    @Override public List<SachEntity> searchByTenLike(String keyword) {
        String k = keyword.toLowerCase(Locale.ROOT);
        List<SachEntity> rs = new ArrayList<>();
        for (SachEntity s : findAll()) if (s.getTen().toLowerCase(Locale.ROOT).contains(k)) rs.add(s);
        return rs;
    }
}