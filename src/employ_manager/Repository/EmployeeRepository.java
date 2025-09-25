package employ_manager.Repository;

import employ_manager.Entity.EmployeeEntity;
import employ_manager.Util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{
    private final String path = "src/employ_manager/Data/employess.csv";

    @Override
    public List<EmployeeEntity> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(path);
        List<EmployeeEntity> rs = new ArrayList<>();
        for (String l : lines) {
            if (l == null || l.isBlank()) continue;
            String[] a = l.split(",");
            if (a.length < 10) continue;
            rs.add(new EmployeeEntity(
                    a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8], Double.parseDouble(a[9])
            ));
        }
        return rs;

    }

    @Override
    public void add(EmployeeEntity e) {
        ReadAndWriteFile.writeFile(path, List.of(e.toCsv()), true);
    }

    @Override
    public boolean deleteByCode(String code) {
        List<EmployeeEntity> all = findAll();
        boolean removed = all.removeIf(x -> x.getCode().equals(code));
        if (removed) {
            List<String> out = new ArrayList<>();
            for (EmployeeEntity e : all) out.add(e.toCsv());
            ReadAndWriteFile.writeFile(path, out, false);
        }
        return removed;
    }



    @Override
    public boolean existsCode(String code) {
        return false;
    }
}