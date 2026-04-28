package za.ac.cput.controller;

import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;
import java.util.List;

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController() {
        this.service = new EmployeeService();
    }

    public String createEmployee(Employee employee) {
        try {
            Employee created = service.createEmployee(employee);
            return "Employee created successfully: " + created.getEmployeeId();
        } catch (Exception e) {
            return "Error creating employee: " + e.getMessage();
        }
    }

    public String getEmployee(String employeeId) {
        try {
            Employee employee = service.getEmployeeById(employeeId);
            return "Employee found: " + employee.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllEmployees() {
        try {
            List<Employee> employees = service.getAllEmployees();
            return "Total employees: " + employees.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updateEmployee(Employee employee) {
        try {
            Employee updated = service.updateEmployee(employee);
            return "Employee updated successfully";
        } catch (Exception e) {
            return "Error updating employee: " + e.getMessage();
        }
    }

    public String deleteEmployee(String employeeId) {
        try {
            service.deleteEmployee(employeeId);
            return "Employee deleted successfully";
        } catch (Exception e) {
            return "Error deleting employee: " + e.getMessage();
        }
    }
}

