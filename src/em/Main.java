package em;

import em.controller.EmployeeController;
import em.repository.EmployeeRepositoryCsv;
import em.repository.IEmployeeRepository;
import em.service.EmployeeService;
import em.service.IEmployeeService;

public class Main {
    private static final String CSV_PATH = "data/employees.csv";

    public static void main(String[] args) {
        IEmployeeRepository repo = new EmployeeRepositoryCsv(CSV_PATH);
        IEmployeeService service = new EmployeeService(repo);
        EmployeeController controller = new EmployeeController(service);
        controller.menuLoop();
    }
}
