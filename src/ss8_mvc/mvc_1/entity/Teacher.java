package ss8_mvc.entity;

public class Teacher extends Person{
    private double salary;

    public Teacher() {
    }
    public Teacher(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }
}