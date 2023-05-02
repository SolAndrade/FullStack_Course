
import java.util.UUID;

public class Course {

    private String courseID;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
        this.courseID = generateCourseId();
        this.money_earned = 0;
        this.teacher = null;
    }

    String generateCourseId() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    public String getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        String courseIdLine = "Course ID: " + courseID + "\n";
        String nameLine = "Name: " + name + "\n";
        String priceLine = "Price: " + String.format("$%.2f", price) + "\n";
        String moneyEarnedLine = "Money Earned: " + String.format("$%.2f", money_earned) + "\n";
        String teacherLine = "Teacher: " +(teacher != null ? getTeacher(): " N/A ") + "\n";
        String separatorLine = "---------------------------\n";

        return Styles.BOLD + Styles.PURPLE_BG.toString() + "COURSE\n" + Styles.RESET +
                separatorLine +
                courseIdLine +
                nameLine +
                priceLine +
                moneyEarnedLine +
                teacherLine +
                separatorLine;
    }
}
