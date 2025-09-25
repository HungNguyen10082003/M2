package employ_manager.Service;

import employ_manager.Entity.EmployeeEntity;
import employ_manager.Repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository repo;
    public EmployeeService(IEmployeeRepository repo) { this.repo = repo; }

    @Override public List<EmployeeEntity> getAll() { return repo.findAll(); }

    @Override public void add(EmployeeEntity e) {
        if (!EmployeeRule.code(e.getCode())) throw new IllegalArgumentException("Mã nhân viên dạng EM-xxx");
        if (!EmployeeRule.idCard(e.getIdCard())) throw new IllegalArgumentException("CMND/CCCD 9-12 số");
        if (!EmployeeRule.phone(e.getPhone())) throw new IllegalArgumentException("SĐT");
        if (!EmployeeRule.email(e.getEmail())) throw new IllegalArgumentException("Email không hợp lệ");
        if (!EmployeeRule.level(e.getLevel())) throw new IllegalArgumentException("Trình độ: Trung cấp/Cao đẳng/Đại học/Sau đại học");
        if (!EmployeeRule.position(e.getPosition())) throw new IllegalArgumentException("Vị trí: lễ tân/phục vụ/chuyên viên/giám sát/quản lý/giám đốc");
        if (!EmployeeRule.salary(e.getSalary())) throw new IllegalArgumentException("Lương >= 0");
        if (repo.existsCode(e.getCode())) throw new IllegalArgumentException("Mã nhân viên đã tồn tại");
        repo.add(e);
    }

    @Override public boolean removeByCode(String code) { return repo.deleteByCode(code); }
    @Override public boolean exists(String code) { return repo.existsCode(code); }
}