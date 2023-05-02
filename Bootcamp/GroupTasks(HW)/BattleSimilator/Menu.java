import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String schoolName;
    private int teachersNumber;
    private List<Teacher> teachersList = new ArrayList<>();
    static final Scanner INPUT = new Scanner(System.in);


    public void startApplication() {
        System.out.println("Introduce the school name: ");
        schoolName = INPUT.nextLine();
        System.out.println("Your school is: " + schoolName);
        System.out.println("How many teachers are in your school?");
        teachersNumber = INPUT.nextInt();

        for(int i = 0; i < teachersNumber; i++) {
            Scanner scannerFor = new Scanner(System.in);
            System.out.println("Teacher's name:");
                String teacherName = scannerFor.nextLine();
                System.out.println("Teacher's salary:");
                double teacherSalary = scannerFor.nextDouble();

                Teacher teacherInput = new Teacher(teacherName, teacherSalary);
                teachersList.add(teacherInput);
                //scannerFor.close();
        }
        System.out.println(teachersList);
    }
}
