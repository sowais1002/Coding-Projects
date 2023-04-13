import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        EmployeeDaoImp newEmp = new EmployeeDaoImp();
        do {
            System.out.println("\t\t\t\tEMPLOYEE MANAGEMENT SYSTEM\n\n" +
                    "Choose from the given options:\n" +
                    "1. Add new Employee\n" +
                    "2. View All Employee\n" +
                    "3. Delete Employee\n" +
                    "4. Update Employee\n" +
                    "5. Get Employee by Id\n" +
                    "6. Get Employee by Name\n" +
                    "0. Exit");
            n = sc.nextInt();
            switch (n){
                case 1:
                    newEmp.addEmployee();
                    break;
                case 2:
                    newEmp.viewAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter Employee Id to be deleted:");
                    int idToDel = sc.nextInt();
                    newEmp.deleteEmployee(idToDel);
                    break;
                case 4:
                    System.out.println("Enter the Id to be updated:");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter updated Name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter Age:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Designation:");
                    String designation = sc.nextLine();
                    System.out.println("Enter Department:");
                    String department = sc.nextLine();
                    Employee updatedEmp = new Employee(idUpdate,newName,age,designation,department);
                    newEmp.updateEmployee(updatedEmp);
                    break;
                case 5:
                    System.out.println("Enter the Id:");
                    int getId = sc.nextInt();
                    newEmp.getEmployeeById(getId);
                    break;
                case 6:
                    System.out.println("Enter the Name:");
                    String getName = sc.nextLine();
                    newEmp.getEmployeeByName(getName);
                    break;
                case 0:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Input!\nPlease choose from given choices only");
            }
        } while (n != 0);
    }
}
