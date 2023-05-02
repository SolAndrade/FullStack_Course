import java.util.UUID;

public class Teacher {

    private String teacherId;
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.teacherId = generateTeacherId();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String generateTeacherId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
