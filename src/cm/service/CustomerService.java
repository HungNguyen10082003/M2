package cm.service;

import cm.entity.Customer;
import cm.repository.ICustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository repo;
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public CustomerService(ICustomerRepository repo) { this.repo = repo; }

    @Override
    public List<Customer> getAll() { return repo.findAll(); }

    @Override
    public Customer getById(int id) { return repo.findById(id); }

    @Override
    public Customer create(String name, String email, String address) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        if (!isValidEmail(email)) throw new IllegalArgumentException("Invalid email");
        if (repo.existsEmail(email, null)) throw new IllegalArgumentException("Email already exists");
        int id = repo.getNextId();
        Customer c = new Customer(id, name.trim(), email.trim(), address == null ? "" : address.trim(), LocalDateTime.now());
        repo.add(c);
        return c;
    }

    @Override
    public boolean update(int id, String name, String email, String address) {
        Customer old = repo.findById(id);
        if (old == null) return false;
        if (name != null && !name.isBlank()) old.setName(name.trim());
        if (email != null && !email.isBlank()) {
            if (!isValidEmail(email)) throw new IllegalArgumentException("Invalid email");
            if (repo.existsEmail(email, id)) throw new IllegalArgumentException("Email already exists");
            old.setEmail(email.trim());
        }
        if (address != null) old.setAddress(address.trim());
        return repo.update(old);
    }

    @Override
    public boolean delete(int id) { return repo.delete(id); }

    @Override
    public List<Customer> searchByName(String keyword) { return repo.findByName(keyword); }

    @Override
    public boolean isValidEmail(String email) {
        return email != null && EMAIL_REGEX.matcher(email).matches();
    }
}
