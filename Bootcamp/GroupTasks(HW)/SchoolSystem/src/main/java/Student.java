import java.util.UUID;

public class Student {

    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;

    public Student(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.studentId = generateStudentId();
        this.course = null;
    }

    private String generateStudentId() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        String studentIdLine = "Student ID: " + studentId + "\n";
        String nameLine = "Name: " + name + "\n";
        String addressLine = "Address: " + address + "\n";
        String emailLine = "Email: " + email + "\n";
        String courseLine = "Course: " + (course != null ? course.getName() : " N/A ") + "\n";
        String separatorLine = "---------------------------\n";

        return Styles.BOLD + Styles.GREEN_BG.toString() + "STUDENT INFO:\n" + Styles.RESET +
                separatorLine +
                studentIdLine +
                nameLine +
                addressLine +
                emailLine +
                courseLine +
                separatorLine;
    }
}
