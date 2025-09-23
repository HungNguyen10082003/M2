package cm.repository;

import cm.entity.Customer;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    void add(Customer c);
    boolean update(Customer c);
    boolean delete(int id);
    List<Customer> findByName(String keyword);
    boolean existsEmail(String email, Integer excludeId);
    int getNextId();
    void saveFile();
}
