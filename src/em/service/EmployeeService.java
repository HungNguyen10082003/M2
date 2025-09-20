package em.service;

import em.entity.EmployeeEntity;
import em.repository.IEmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository repo;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    public EmployeeService(IEmployeeRepository repo) { this.repo = repo; }

    @Override
    public List<EmployeeEntity> getAll() { return repo.findAll(); }

    @Override
    public Optional<EmployeeEntity> getById(int id) { return repo.findById(id); }

    @Override
    public EmployeeEntity create(String name, String email, String department, double salary) {
        validate(name, email, department, salary);
        EmployeeEntity e = new EmployeeEntity(0, name.trim(), email.trim(), department.trim(), salary);
        repo.save(e);
        return e;
    }

    @Override
    public EmployeeEntity update(int id, String name, String email, String department, double salary) {
        validate(name, email, department, salary);
        EmployeeEntity e = new EmployeeEntity(id, name.trim(), email.trim(), department.trim(), salary);
        repo.update(e);
        return e;
    }

    @Override
    public boolean delete(int id) { return repo.deleteById(id); }

    private void validate(String name, String email, String department, double salary) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) throw new IllegalArgumentException("Invalid email");
        if (department == null || department.isBlank()) throw new IllegalArgumentException("Department is required");
        if (salary < 0) throw new IllegalArgumentException("Salary must be >= 0");
    }
}
