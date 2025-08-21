package ss8_mvc.service;

import ss8_mvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add(Student student);
}