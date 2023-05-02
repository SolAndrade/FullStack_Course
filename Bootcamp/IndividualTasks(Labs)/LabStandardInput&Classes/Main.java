import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = createEmployees();

        try {
            FileWriter writer = new FileWriter("employees.txt");

            for (Employee employee : employees) {
                writer.write("ID: " + employee.getEmployeeID() + "\n");
                writer.write("Name: " + employee.getName() + "\n");
                writer.write("Salary: $" + employee.getSalary() + "\n");
                writer.write("\n");
            }

            writer.close();
            System.out.println("Employees data saved to employees.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    private static Employee[] createEmployees() {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("John Doe", 10000.0, 1001);
        employees[1] = new Employee("Jane Smith", 20000.0, 1002);
        employees[2] = new Employee("Bob Johnson", 15000.0, 1003);
        employees[3] = new Employee("Alice Williams", 13000.0, 1004);
        employees[4] = new Employee("Mike Brown", 17000.0, 1005);
        employees[5] = new Employee("Sarah Davis", 19000.0, 1006);
        employees[6] = new Employee("Tom Wilson", 18000.0, 1007);
        employees[7] = new Employee("Laura Lee", 18000.0, 1008);
        employees[8] = new Employee("Alex Green", 20000.0, 1009);
        employees[9] = new Employee("Sam Taylor", 16000.0, 1010);

        return employees;
    }
}
