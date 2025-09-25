package employ_manager.Repository;

import java.util.List;

public interface IFacilityRepository<T> {
    List<T> findAll();
    void add(T t);
    boolean deleteByCode(String code);
    boolean existsCode(String code);
}
