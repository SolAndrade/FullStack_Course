public class Employee {
    private String name;
    private double salary;
    private int employeeID;

    public Employee(String name, double salary, int employeeID) {
        this.name = name;
        this.salary = salary;
        this.employeeID = employeeID;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
