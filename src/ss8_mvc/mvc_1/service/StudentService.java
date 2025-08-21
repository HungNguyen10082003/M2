package ss8_mvc.service;

import ss8_mvc.entity.Student;
import ss8_mvc.repository.IStudentRepository;
import ss8_mvc.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        List<Student> students = studentRepository.findAll();
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i)!=null){
                if (students.get(i).getId()==student.getId()){
                    System.out.println("id đã tồn tại");
                    return false;
                }
            }else {
                break;
            }

        }
        return studentRepository.add(student);
    }
}