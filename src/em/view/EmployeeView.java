package em.view;

import em.entity.EmployeeEntity;

import java.util.List;

public class EmployeeView {
    public void printHeader() {
        System.out.println("ID   | Name                 | Email                     | Department   |   Salary");
    }

    public void showList(List<EmployeeEntity> list) {
        printHeader();
        for (EmployeeEntity e : list) {
            System.out.println(e);
        }
    }

    public void showDetail(EmployeeEntity e) {
        printHeader();
        System.out.println(e);
    }

    public void showMessage(String msg) { System.out.println(msg); }
}
