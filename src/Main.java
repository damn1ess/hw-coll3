import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Employee> employees = new HashMap<>();

    private static void printSeparator() {
        System.out.println("================================================================================");
    }

    private static void showEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    private static void addEmployee(Employee employee) {
        String key = employee.getFirstName() + " " + employee.getLastName();
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
        } else {
            System.out.println("Сотрудник с таким ФИО уже существует.");
        }
    }

    private static void removeEmployee(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        if (employees.remove(key) == null) {
            System.out.println("Сотрудник не найден.");
        }
    }

    private static Employee findEmployee(String firstName, String lastName) {
        return employees.get(firstName + " " + lastName);
    }

    private static double toSumSalaries() {
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }

    private static double toSumSalariesDepartments(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    private static Employee findMinSalary() {
        return employees.values().stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).orElse(null);
    }

    private static Employee findMaxSalary() {
        return employees.values().stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).orElse(null);
    }

    private static double findAverageSalary() {
        return toSumSalaries() / employees.size();
    }

    private static void indexesTheSalary(int indexPercent) {
        double valueOfIndex = (double) indexPercent / 100;
        for (Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * valueOfIndex);
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee("Artyom", "Polzikov", 1, 76_650));
        addEmployee(new Employee("Gennady", "Chernenko", 3, 53_000));
        addEmployee(new Employee("Sergey", "Krasnov", 2, 47_124));
        addEmployee(new Employee("Alexandr", "Ostankov", 4, 86_030));
        addEmployee(new Employee("Oxana", "Didenko", 5, 31_472));
        addEmployee(new Employee("Vitally", "Zozulin", 2, 123_984));
        addEmployee(new Employee("Ivan", "Tihonenko", 3, 87_178));
        addEmployee(new Employee("Valery", "Atanov", 4, 79_764));
        addEmployee(new Employee("illya", "Shatilov", 5, 75_651));
        addEmployee(new Employee("Alexandra", "Volod'ko", 1, 28_453));

        // Базовая сложность
        showEmployees();
        printSeparator();
        System.out.println("Сумма зарплат: " + Math.round(toSumSalaries()));
        printSeparator();
        System.out.println(findMaxSalary());
        printSeparator();
        System.out.println(findMinSalary());
        printSeparator();
        System.out.println("Средняя зарплата: " + Math.round(findAverageSalary()));

        // Повышенная сложность
        indexesTheSalary(10);
        System.out.println("\n\nСумма зарплат сотрудников первого отдела: " + Math.round(toSumSalariesDepartments(1)));
        printSeparator();
        removeEmployee("Gennady", "Chernenko");
        showEmployees();
    }
}