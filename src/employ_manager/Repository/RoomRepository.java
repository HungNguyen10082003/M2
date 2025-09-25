package employ_manager.Repository;

import employ_manager.Entity.RoomEntity;
import employ_manager.Util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements IFacilityRepository<RoomEntity> {
    private final String path = "src/employ_manager/data/rooms.csv";

    @Override
    public List<RoomEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<RoomEntity> rs = new ArrayList<>();
        for (String l : lines) {
            if (l == null || l.isBlank()) continue;
            String[] a = l.split(",");
            if (a.length < 8) continue; // TYPE,code,name,area,cost,maxPeople,rental,freeService
            rs.add(new RoomEntity(
                    a[1], a[2],
                    Double.parseDouble(a[3]),
                    Double.parseDouble(a[4]),
                    Integer.parseInt(a[5]),
                    a[6], a[7]
            ));
        }
        return rs;
    }

    @Override
    public void add(RoomEntity r) {
        ReadAndWriteFile.writeFile(path, List.of(r.toCsv()), true);
    }

    @Override
    public boolean deleteByCode(String code) {
        List<RoomEntity> all = findAll();
        boolean removed = all.removeIf(x -> x.getCode().equals(code));
        if (removed) {
            List<String> out = new ArrayList<>();
            for (RoomEntity r : all) out.add(r.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return removed;
    }

    @Override
    public boolean existsCode(String code) {
        return findAll().stream().anyMatch(x -> x.getCode().equals(code));
    }
}
