package cm.controller;

import cm.entity.Customer;
import cm.service.ICustomerService;

import java.util.List;

public class CustomerController {
    private final ICustomerService service;

    public CustomerController(ICustomerService service) { this.service = service; }

    public List<Customer> getAll() { return service.getAll(); }
    public Customer create(String name, String email, String address) { return service.create(name, email, address); }
    public boolean update(int id, String name, String email, String address) { return service.update(id, name, email, address); }
    public boolean delete(int id) { return service.delete(id); }
    public List<Customer> searchByName(String keyword) { return service.searchByName(keyword); }
}
