package employ_manager.Service;

import java.util.List;

public interface IFacilityService<T> {
    List<T> getAll();
    void add(T t);
    boolean removeByCode(String code);
    boolean exists(String code);
}
