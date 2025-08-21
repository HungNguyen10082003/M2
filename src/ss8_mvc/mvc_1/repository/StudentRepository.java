package ss8_mvc.repository;

import ss8_mvc.entity.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> students = new LinkedList<>();
    static {
        students.add(new Student(1,"Hưng", 4.5f));
        students.add(new Student(2,"Hào", 8.5f));
    }

    @Override
    public List<Student> findAll() {

        return students;
    }

    @Override
    public boolean add(Student student) {

        students.add(student);
        return true;
    }
}