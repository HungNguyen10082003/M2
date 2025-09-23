package cm.service;

import cm.entity.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer getById(int id);
    Customer create(String name, String email, String address);
    boolean update(int id, String name, String email, String address);
    boolean delete(int id);
    List<Customer> searchByName(String keyword);
    boolean isValidEmail(String email);
}
