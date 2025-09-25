package employ_manager.Repository;

import employ_manager.Entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeEntity> findAll();
    void add(EmployeeEntity e);
    boolean deleteByCode(String code);
    boolean existsCode(String code);
}
