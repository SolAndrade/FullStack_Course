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
        return UUID.randomUUID().toString().substring(0, 5);
    }

    @Override
    public String toString() {
        String teacherIdLine = "Teacher ID: " + teacherId + "\n";
        String nameLine = "Name: " + name + "\n";
        String salaryLine = "Salary: " + String.format("$%.2f", salary) + "\n";
        String separatorLine = "---------------------------\n";


        return Styles.BOLD + Styles.BLUE_BG.toString() + "TEACHER INFO:\n" + Styles.RESET +
                separatorLine +
                teacherIdLine +
                nameLine +
                salaryLine +
                separatorLine;
    }
}
