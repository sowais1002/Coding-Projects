import java.util.*;

public class EmployeeDaoImp implements EmployeeDao{


    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Employee> employeeList = new HashMap<>();
    @Override
    public Employee addEmployee() {
        System.out.println("Enter the Id:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Designation:");
        String designation = sc.nextLine();
        System.out.println("Enter Department:");
        String department = sc.nextLine();
        Employee newEmployee = new Employee(id, name, age, designation, department);
        employeeList.put(id,newEmployee);
        return newEmployee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        int id = employee.getEmployeeId();
        if(employeeList.containsKey(id)){
            employeeList.put(id,employee);
            System.out.println("Employee with Id: "+id+" has been updated!");
        }else{
            System.out.println("Employee with Id: "+id+" not found!");
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        if(employeeList.containsKey(employeeId)){
            Employee employee = employeeList.remove(employeeId);
            System.out.println("Employee with Employee Id: "+employeeId+" has been deleted");
        }
        else{
            System.out.println("Employee with Id "+employeeId+" not found!");
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        if(employeeList.containsKey(employeeId)){
            Employee employee = employeeList.get(employeeId);
            System.out.println("Employee Id: "+ employee.getEmployeeId()+
                    "\nEmployee Name: "+ employee.getEmployeeName()+
                    "\nEmployee Age: "+ employee.getEmployeeAge()+
                    "\nEmployee Designation: "+ employee.getEmployeeDesignation()+
                    "\nEmployee Department: "+ employee.getEmployeeDepartment());
        }else{
            System.out.println("Employee with Id "+employeeId+" not found!");
        }

        return null;
    }

    @Override
    public Employee getEmployeeByName(String employeeName) {
        for(Employee employee : employeeList.values()){
            if(employee.getEmployeeName().equalsIgnoreCase(employeeName)){
                System.out.println("Employee Id: "+ employee.getEmployeeId()+
                        "\nEmployee Name: "+ employee.getEmployeeName()+
                        "\nEmployee Age: "+ employee.getEmployeeAge()+
                        "\nEmployee Designation: "+ employee.getEmployeeDesignation()+
                        "\nEmployee Department: "+ employee.getEmployeeDepartment());
            }
        }
        return null;
    }

    @Override
    public void viewAllEmployee() {
        if(employeeList.isEmpty()){
            System.out.println("No Employee Found");
        }
        else{
            for(Employee employee1: employeeList.values()) {
                System.out.println(employee1.getEmployeeId()+" "+
                        employee1.getEmployeeName()+" "+
                        employee1.getEmployeeAge()+" "+
                        employee1.getEmployeeDesignation()+" "+
                        employee1.getEmployeeDepartment());
            }
        }
    }

}
