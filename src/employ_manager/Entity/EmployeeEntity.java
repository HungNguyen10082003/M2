package employ_manager.Entity;

public class EmployeeEntity {
    private String code;
    private String name;
    private String dob;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String level;
    private String position;
    private double salary;

    public EmployeeEntity() {}

    public EmployeeEntity(String code, String name, String dob, String gender,
                          String idCard, String phone, String email,
                          String level, String position, double salary) {
        this.code = code; this.name = name; this.dob = dob; this.gender = gender;
        this.idCard = idCard; this.phone = phone; this.email = email;
        this.level = level; this.position = position; this.salary = salary;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public String getGender() { return gender; }
    public String getIdCard() { return idCard; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getLevel() { return level; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    public String toCsv() {
        return String.join(",", code, name, dob, gender, idCard, phone, email, level, position, String.valueOf(salary));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}