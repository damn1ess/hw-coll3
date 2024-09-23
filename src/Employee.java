import java.util.Objects;

public class Employee {
    private static int generateId = 1;
    private final int id;
    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public String toString() {
        return getId() + "." + getFirstName() + " " + getLastName() + " " + getDepartment() + " : " + Math.round(getSalary()) + ".";
    }

    public Employee(String firstName, String lastName, int department, double salary) {
        this.id = generateId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }
}