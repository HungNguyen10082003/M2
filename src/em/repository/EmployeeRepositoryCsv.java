package em.repository;

import em.entity.EmployeeEntity;
import em.util.ReadWriteCsv;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepositoryCsv implements IEmployeeRepository {
    private static final String HEADER = "id,name,email,department,salary";
    private final ReadWriteCsv csv;
    private final List<EmployeeEntity> cache = new ArrayList<>();

    public EmployeeRepositoryCsv(String csvPath) {
        this.csv = new ReadWriteCsv(csvPath);
        this.csv.ensureFileExistsWithHeader(HEADER);
        load();
    }

    private void load() {
        cache.clear();
        for (String line : csv.readAllLinesSkipHeader()) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length < 5) continue;
            try {
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String email = parts[2].trim();
                String dept = parts[3].trim();
                double salary = Double.parseDouble(parts[4].trim());
                cache.add(new EmployeeEntity(id, name, email, dept, salary));
            } catch (NumberFormatException ignored) {}
        }
        sortById();
    }

    private void persist() {
        List<String> lines = cache.stream()
                .map(e -> e.getId()+","+e.getName()+","+e.getEmail()+","+e.getDepartment()+","+e.getSalary())
                .collect(Collectors.toList());
        csv.writeAllWithHeader(HEADER, lines);
    }

    private void sortById() { cache.sort(Comparator.comparingInt(EmployeeEntity::getId)); }

    @Override
    public List<EmployeeEntity> findAll() { return new ArrayList<>(cache); }

    @Override
    public Optional<EmployeeEntity> findById(int id) {
        return cache.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(EmployeeEntity employee) {
        if (employee.getId() == 0) employee.setId(nextId());
        cache.add(employee);
        sortById();
        persist();
    }

    @Override
    public void update(EmployeeEntity employee) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getId() == employee.getId()) {
                cache.set(i, employee);
                persist();
                return;
            }
        }
        throw new NoSuchElementException("Employee not found id=" + employee.getId());
    }

    @Override
    public boolean deleteById(int id) {
        boolean removed = cache.removeIf(e -> e.getId() == id);
        if (removed) persist();
        return removed;
    }

    @Override
    public int nextId() {
        return cache.stream().mapToInt(EmployeeEntity::getId).max().orElse(0) + 1;
    }
}
