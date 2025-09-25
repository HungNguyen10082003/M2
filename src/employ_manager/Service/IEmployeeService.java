package employ_manager.Service;

import employ_manager.Entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeEntity> getAll();
    void add(EmployeeEntity e);
    boolean removeByCode(String code);
    boolean exists(String code);
}