
// -------------- MAIN PROGRAM ---------------
public class Main {
    public static void main(String args[]) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Create Employees
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Raj", 2, 40, 100);

        // Add Employees to ArrayList
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        // Add Employees to Database
        payrollSystem.addEmployeeToDatabase(emp1);
        payrollSystem.addEmployeeToDatabase(emp2);

        // Display Employees from ArrayList
        System.out.println("Initial Employee Details from ArrayList ");
        payrollSystem.displayEmployees();

        // Fetch Employees from Database
        System.out.println("\nEmployees from Database ");
        payrollSystem.fetchEmployeesFromDatabase();

        // Remove an Employee
        System.out.println("\nRemoving Employee with ID 2 .");
        payrollSystem.removeEmployee(2);
        payrollSystem.removeEmployeeFromDatabase(2);*/

        // Display Remaining Employees
        System.out.println("Remaining Employees from ArrayList");
        payrollSystem.displayEmployees();

        System.out.println("\nRemaining Employees from Database:");
        payrollSystem.fetchEmployeesFromDatabase();
    }
}
