package coursemanager.repository;

import java.util.List;

public interface IKhoaHocRepository<T> {
    void add(T t);
    List<T> findAll();
    boolean deleteByMa(String ma);
    boolean existsMa(String ma);
    List<T> searchByTenLike(String keyword);
}
