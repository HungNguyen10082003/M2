package employ_manager.Repository;

import employ_manager.Entity.VillaEntity;
import employ_manager.Util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class VillaRepository implements IFacilityRepository<VillaEntity> {
    private final String path = "src/employ_manager/data/villas.csv";

    @Override
    public List<VillaEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<VillaEntity> rs = new ArrayList<>();
        for (String l : lines) {
            if (l == null || l.isBlank()) continue;
            String[] a = l.split(",");
            if (a.length < 10) continue; // TYPE,code,name,area,cost,maxPeople,rental,standard,pool,floors
            rs.add(new VillaEntity(
                    a[1], a[2],
                    Double.parseDouble(a[3]),
                    Double.parseDouble(a[4]),
                    Integer.parseInt(a[5]),
                    a[6], a[7],
                    Double.parseDouble(a[8]),
                    Integer.parseInt(a[9])
            ));
        }
        return rs;
    }

    @Override
    public void add(VillaEntity v) {
        ReadAndWriteFile.writeFile(path, List.of(v.toCsv()), true); // append
    }

    @Override
    public boolean deleteByCode(String code) {
        List<VillaEntity> all = findAll();
        boolean removed = all.removeIf(x -> x.getCode().equals(code));
        if (removed) {
            List<String> out = new ArrayList<>();
            for (VillaEntity v : all) out.add(v.toCsv());
            ReadAndWriteFile.writeFile(path, out, false); // overwrite
        }
        return removed;
    }

    @Override
    public boolean existsCode(String code) {
        return findAll().stream().anyMatch(x -> x.getCode().equals(code));
    }
}
