package em.service;

import em.entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<EmployeeEntity> getAll();
    Optional<EmployeeEntity> getById(int id);
    EmployeeEntity create(String name, String email, String department, double salary);
    EmployeeEntity update(int id, String name, String email, String department, double salary);
    boolean delete(int id);
}
