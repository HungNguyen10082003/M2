package cm.view;

import cm.controller.CustomerController;
import cm.repository.CustomerRepository;
import cm.repository.ICustomerRepository;
import cm.service.CustomerService;
import cm.service.ICustomerService;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = Paths.get("data", "customers.csv").toAbsolutePath().toString();
        System.out.println("CSV path = " + filePath);
        ICustomerRepository repo = new CustomerRepository(filePath);
        ICustomerService service = new CustomerService(repo);
        CustomerController controller = new CustomerController(service);
        new CustomerView(controller).showMenu();
    }
}
