package za.ac.cput;

import za.ac.cput.controller.*;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System - DDD Demonstration ===\n");

        // Create Controllers
        EmployeeController empController = new EmployeeController();
        DepartmentController deptController = new DepartmentController();
        PositionController posController = new PositionController();
        AddressController addrController = new AddressController();
        ContactController contController = new ContactController();
        SalaryController salController = new SalaryController();
        LeaveController leaveController = new LeaveController();
        EmployeePerformanceController perfController = new EmployeePerformanceController();

        // Create Department
        System.out.println("--- Creating Department ---");
        Department dept = DepartmentFactory.createDepartment("D001", "IT", "Information Technology", "E001");
        System.out.println(deptController.createDepartment(dept));

        // Create Position
        System.out.println("\n--- Creating Position ---");
        Position pos = PositionFactory.createPosition("P001", "Senior Developer", "Development", 95000.0);
        System.out.println(posController.createPosition(pos));

        // Create Address
        System.out.println("\n--- Creating Address ---");
        Address addr = AddressFactory.createAddress("A001", "123 Tech Street", "Cape Town", "Western Cape", "8000", "South Africa");
        System.out.println(addrController.createAddress(addr));

        // Create Contact
        System.out.println("\n--- Creating Contact ---");
        Contact contact = ContactFactory.createContact("C001", "021-555-0123", "083-555-0456", "Jane Doe", "083-555-0789");
        System.out.println(contController.createContact(contact));

        // Create Employee
        System.out.println("\n--- Creating Employee ---");
        Employee emp = EmployeeFactory.createEmployee("E001", "John", "Doe",
            LocalDate.of(1990, 5, 15), "john.doe@company.com",
            LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");
        System.out.println(empController.createEmployee(emp));

        // Create Salary
        System.out.println("\n--- Creating Salary ---");
        Salary salary = SalaryFactory.createSalary("S001", "E001", 95000.0, 5000.0, 2000.0, LocalDate.of(2024, 1, 1));
        System.out.println(salController.createSalary(salary));
        System.out.println("Net Salary: " + Helper.formatCurrency(salary.calculateNetSalary()));

        // Create Leave
        System.out.println("\n--- Creating Leave ---");
        Leave leave = LeaveFactory.createLeave("L001", "E001", "Annual",
            LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 10), "Approved", "Vacation");
        System.out.println(leaveController.createLeave(leave));
        System.out.println("Leave days: " + leave.calculateDays());

        // Create Performance
        System.out.println("\n--- Creating Performance Review ---");
        EmployeePerformance perf = EmployeePerformanceFactory.createEmployeePerformance("PERF001", "E001",
            4.5, "Excellent technical skills", LocalDate.of(2024, 3, 15), "Manager A");
        System.out.println(perfController.createPerformance(perf));
        System.out.println("Performance Level: " + perf.getPerformanceLevel());

        // Retrieve Data
        System.out.println("\n--- Retrieving Data ---");
        System.out.println(empController.getEmployee("E001"));
        System.out.println(deptController.getDepartment("D001"));
        System.out.println(posController.getPosition("P001"));

        // Display Employee Age
        System.out.println("\n--- Employee Information ---");
        int age = Helper.calculateAge(emp.getDateOfBirth());
        System.out.println("Employee Age: " + age + " years");
        System.out.println("Email Validation: " + Helper.isValidEmail(emp.getEmail()));
        System.out.println("Phone Validation: " + Helper.isValidPhoneNumber(contact.getCellPhone()));

        System.out.println("\n=== System demonstrates DDD with 8 Entities and full CRUD operations ===");
    }
}