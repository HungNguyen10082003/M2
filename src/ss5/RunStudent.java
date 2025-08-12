package ss5;

public class RunStudent {
    public static void main(String[] args) {
        Student s = new Student();

        System.out.println("Name: " + s.getName());
        System.out.println("Classes: " + s.getClasses());

        s.setName("Hữu Hưng");
        s.setClasses("C05");

        System.out.println("Name: " + s.getName());
        System.out.println("Classes: " + s.getClasses());
    }

}
