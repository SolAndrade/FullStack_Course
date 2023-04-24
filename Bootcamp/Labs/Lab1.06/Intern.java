public class Intern extends Employee {
    private static final double MAX_SALARY = 20000.0;

    public Intern(String name, double salary, int employeeID) {
        super(name, salary, employeeID);
        validateSalary();
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(salary);
        validateSalary();
    }

    private void validateSalary() {
        if (getSalary() > MAX_SALARY) {
            super.setSalary(MAX_SALARY);
        }
    }
}
