package em.repository;

import em.entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    List<EmployeeEntity> findAll();
    Optional<EmployeeEntity> findById(int id);
    void save(EmployeeEntity employee);
    void update(EmployeeEntity employee);
    boolean deleteById(int id);
    int nextId();
}
