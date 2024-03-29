import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;

    public Department(){
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }
    public void addEmployee(Employee emp){
        this.employees.add(emp);
    }

    public double getAverageSalary() {
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}
