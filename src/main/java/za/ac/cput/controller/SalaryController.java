package za.ac.cput.controller;

import za.ac.cput.domain.Salary;
import za.ac.cput.service.SalaryService;
import java.util.List;

public class SalaryController {
    private final SalaryService service;

    public SalaryController() {
        this.service = new SalaryService();
    }

    public String createSalary(Salary salary) {
        try {
            Salary created = service.createSalary(salary);
            return "Salary created successfully: " + created.getSalaryId();
        } catch (Exception e) {
            return "Error creating salary: " + e.getMessage();
        }
    }

    public String getSalary(String salaryId) {
        try {
            Salary salary = service.getSalaryById(salaryId);
            return "Salary found: " + salary.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllSalaries() {
        try {
            List<Salary> salaries = service.getAllSalaries();
            return "Total salaries: " + salaries.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getSalariesByEmployee(String employeeId) {
        try {
            List<Salary> salaries = service.getSalariesByEmployeeId(employeeId);
            return "Employee salaries: " + salaries.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updateSalary(Salary salary) {
        try {
            Salary updated = service.updateSalary(salary);
            return "Salary updated successfully";
        } catch (Exception e) {
            return "Error updating salary: " + e.getMessage();
        }
    }

    public String deleteSalary(String salaryId) {
        try {
            service.deleteSalary(salaryId);
            return "Salary deleted successfully";
        } catch (Exception e) {
            return "Error deleting salary: " + e.getMessage();
        }
    }
}

