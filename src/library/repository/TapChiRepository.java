package library.repository;

import library.entity.TapChiEntity;
import library.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TapChiRepository implements ITaiLieuRepository<TapChiEntity> {
    private final String path = "src/library/data/tapchi.csv";

    @Override
    public List<TapChiEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<TapChiEntity> rs = new ArrayList<>();
        for (String l : lines) {
            String[] a = l.split(",");
            if (a.length < 7) continue;
            rs.add(new TapChiEntity(a[1], a[2], Integer.parseInt(a[3]), a[4],
                    Integer.parseInt(a[5]), Integer.parseInt(a[6])));
        }
        return rs;
    }

    @Override public void add(TapChiEntity t) { ReadAndWriteFile.writeFile(path, List.of(t.toCsv()), true); }

    @Override public boolean deleteByMa(String ma) {
        List<TapChiEntity> all = findAll();
        boolean ok = all.removeIf(x -> x.getMa().equals(ma));
        if (ok) {
            List<String> out = new ArrayList<>();
            for (TapChiEntity t : all) out.add(t.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return ok;
    }

    @Override public boolean existsMa(String ma) { return findAll().stream().anyMatch(x -> x.getMa().equals(ma)); }

    @Override public List<TapChiEntity> searchByTenLike(String keyword) {
        String k = keyword.toLowerCase(Locale.ROOT);
        List<TapChiEntity> rs = new ArrayList<>();
        for (TapChiEntity t : findAll()) if (t.getTen().toLowerCase(Locale.ROOT).contains(k)) rs.add(t);
        return rs;
    }
}