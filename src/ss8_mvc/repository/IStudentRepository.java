package ss8_mvc.repository;

import ss8_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    boolean add(Student student);
}