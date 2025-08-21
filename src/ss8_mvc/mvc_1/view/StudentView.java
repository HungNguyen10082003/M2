
package ss8_mvc.view;

import ss8_mvc.entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayList(List<Student> studentList){
        for (Student student: studentList) {
            if (student !=null){
                System.out.println(student);
            }else {
                break;
            }

        }
    }
    public static Student inputDataForNewStudent(){
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập điểm");
        float score = Float.parseFloat(scanner.nextLine());
        Student student = new Student(id,name,score);
        return student;
    }
}
