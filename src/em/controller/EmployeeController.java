package em.controller;

import em.entity.EmployeeEntity;
import em.service.IEmployeeService;
import em.view.EmployeeView;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EmployeeController {
    private final IEmployeeService service;
    private final EmployeeView view = new EmployeeView();
    private final Scanner sc = new Scanner(System.in);

    public EmployeeController(IEmployeeService service) { this.service = service; }

    public void menuLoop() {
        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. List all");
            System.out.println("2. Find by ID");
            System.out.println("3. Create");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> listAll();
                case "2" -> findById();
                case "3" -> create();
                case "4" -> update();
                case "5" -> delete();
                case "0" -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void listAll() {
        List<EmployeeEntity> list = service.getAll();
        view.showList(list);
    }

    private void findById() {
        try {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(sc.nextLine());
            Optional<EmployeeEntity> e = service.getById(id);
            e.ifPresentOrElse(view::showDetail, () -> view.showMessage("Not found"));
        } catch (NumberFormatException e) {
            view.showMessage("ID must be a number");
        }
    }

    private void create() {
        try {
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(sc.nextLine());
            EmployeeEntity created = service.create(name, email, dept, salary);
            view.showMessage("Created with id=" + created.getId());
        } catch (Exception ex) {
            view.showMessage("Create failed: " + ex.getMessage());
        }
    }

    private void update() {
        try {
            System.out.print("ID to update: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(sc.nextLine());
            service.update(id, name, email, dept, salary);
            view.showMessage("Updated!");
        } catch (Exception ex) {
            view.showMessage("Update failed: " + ex.getMessage());
        }
    }

    private void delete() {
        try {
            System.out.print("ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());
            boolean ok = service.delete(id);
            view.showMessage(ok ? "Deleted!" : "Not found!");
        } catch (NumberFormatException e) {
            view.showMessage("ID must be a number");
        }
    }
}
