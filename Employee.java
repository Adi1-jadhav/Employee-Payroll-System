import java.sql.*;
import java.util.ArrayList;

// -------------- DATABASE CONNECTION CLASS ---------------
class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll";
    private static final String USER = "root"; // Change if needed
    private static final String PASSWORD = "password"; // Change if needed

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

// -------------- ABSTRACT EMPLOYEE CLASS ---------------
abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

// -------------- FULL-TIME EMPLOYEE CLASS ---------------
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// -------------- PART-TIME EMPLOYEE CLASS ---------------
class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// -------------- PAYROLL SYSTEM CLASS ---------------
class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    // Add Employee to ArrayList
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Remove Employee from ArrayList
    public void removeEmployee(int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
    }

    // Display all employees
    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    // ----------- DATABASE METHODS -----------

    // Add Employee to Database
    public void addEmployeeToDatabase(Employee employee) {
        String sql = "INSERT INTO Employees (id, name, type, monthlySalary, hoursWorked, hourlyRate) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());

            if (employee instanceof FullTimeEmployee) {
                stmt.setString(3, "FullTime");
                stmt.setDouble(4, ((FullTimeEmployee) employee).calculateSalary());
                stmt.setNull(5, Types.INTEGER);
                stmt.setNull(6, Types.DOUBLE);
            } else if (employee instanceof PartTimeEmployee) {
                stmt.setString(3, "PartTime");
                stmt.setNull(4, Types.DOUBLE);
                stmt.setInt(5, ((PartTimeEmployee) employee).hoursWorked);
                stmt.setDouble(6, ((PartTimeEmployee) employee).hourlyRate);
            }

            stmt.executeUpdate();
            System.out.println("Employee added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve All Employees from Database
    public void fetchEmployeesFromDatabase() {
        String sql = "SELECT * FROM Employees";

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");

                if (type.equals("FullTime")) {
                    double monthlySalary = rs.getDouble("monthlySalary");
                    System.out.println(new FullTimeEmployee(name, id, monthlySalary));
                } else {
                    int hoursWorked = rs.getInt("hoursWorked");
                    double hourlyRate = rs.getDouble("hourlyRate");
                    System.out.println(new PartTimeEmployee(name, id, hoursWorked, hourlyRate));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove Employee from Database
    public void removeEmployeeFromDatabase(int id) {
        String sql = "DELETE FROM Employees WHERE id = ?";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee removed from database.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
