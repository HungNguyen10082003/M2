package ss8_mvc.controller;

import ss8_mvc.entity.Student;
import ss8_mvc.service.IStudentService;
import ss8_mvc.service.StudentService;
import ss8_mvc.view.StudentView;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static void displayMenu() {
        IStudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("------------Quản lý sinh viên----------");
            System.out.println("Chức năng: " +
                    "\n 1. Danh sách" +
                    "\n 2. Thêm mới" +
                    "\n 3. Xoá" +
                    "\n 4. Tìm kiếm" +
                    "\n 5. Qua lại menu chính"
            );
            System.out.println("Chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách");
                    List<Student> studentList = studentService.findAll();
                    StudentView.displayList(studentList);
                    break;
                case 2:
                    System.out.println("Thêm mới");
                    Student student = StudentView.inputDataForNewStudent();
                    boolean isAddSuccess = studentService.add(student);
                    if (isAddSuccess) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                    break;
                case 3:
                    System.out.println("Xoá");
                    // code mở rộng ở đây
                    break;
                case 4:
                    System.out.println("Tìm kiếm");
                    // code mở rộng ở đây
                    break;
                default:
                    System.out.println("Đã kết thúc chương trình");
                    flag = false;
                    break;
            }
        }
    }

}