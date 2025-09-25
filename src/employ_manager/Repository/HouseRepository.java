package employ_manager.Repository;

import employ_manager.Entity.HouseEntity;
import employ_manager.Util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository implements IFacilityRepository<HouseEntity> {
    private final String path = "src/employ_manager/data/houses.csv";

    @Override
    public List<HouseEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<HouseEntity> rs = new ArrayList<>();
        for (String l : lines) {
            if (l == null || l.isBlank()) continue;
            String[] a = l.split(",");
            if (a.length < 9) continue; // TYPE,code,name,area,cost,maxPeople,rental,standard,floors
            rs.add(new HouseEntity(
                    a[1], a[2],
                    Double.parseDouble(a[3]),
                    Double.parseDouble(a[4]),
                    Integer.parseInt(a[5]),
                    a[6], a[7],
                    Integer.parseInt(a[8])
            ));
        }
        return rs;
    }

    @Override
    public void add(HouseEntity h) {
        ReadAndWriteFile.writeFile(path, List.of(h.toCsv()), true);
    }

    @Override
    public boolean deleteByCode(String code) {
        List<HouseEntity> all = findAll();
        boolean removed = all.removeIf(x -> x.getCode().equals(code));
        if (removed) {
            List<String> out = new ArrayList<>();
            for (HouseEntity h : all) out.add(h.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return removed;
    }

    @Override
    public boolean existsCode(String code) {
        return findAll().stream().anyMatch(x -> x.getCode().equals(code));
    }
}
