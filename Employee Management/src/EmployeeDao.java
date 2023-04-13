import java.util.List;

public interface EmployeeDao {

    Employee addEmployee();

    void updateEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    Employee getEmployeeById(int employeeId);

    Employee getEmployeeByName(String employeeName);

    void viewAllEmployee();

}
