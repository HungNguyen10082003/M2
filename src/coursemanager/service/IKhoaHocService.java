package coursemanager.service;

import java.util.List;

public interface IKhoaHocService<T> {
    void add(T t);
    List<T> getAll();
    boolean removeByMa(String ma);
    boolean existsMa(String ma);
    List<T> searchByTenLike(String keyword);
}
