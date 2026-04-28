package za.ac.cput.controller;

import za.ac.cput.domain.EmployeePerformance;
import za.ac.cput.service.EmployeePerformanceService;
import java.util.List;

public class EmployeePerformanceController {
    private final EmployeePerformanceService service;

    public EmployeePerformanceController() {
        this.service = new EmployeePerformanceService();
    }

    public String createPerformance(EmployeePerformance performance) {
        try {
            EmployeePerformance created = service.createPerformance(performance);
            return "Performance created successfully: " + created.getPerformanceId();
        } catch (Exception e) {
            return "Error creating performance: " + e.getMessage();
        }
    }

    public String getPerformance(String performanceId) {
        try {
            EmployeePerformance performance = service.getPerformanceById(performanceId);
            return "Performance found: " + performance.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllPerformances() {
        try {
            List<EmployeePerformance> performances = service.getAllPerformances();
            return "Total performances: " + performances.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getPerformancesByEmployee(String employeeId) {
        try {
            List<EmployeePerformance> performances = service.getPerformancesByEmployeeId(employeeId);
            return "Employee performances: " + performances.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updatePerformance(EmployeePerformance performance) {
        try {
            EmployeePerformance updated = service.updatePerformance(performance);
            return "Performance updated successfully";
        } catch (Exception e) {
            return "Error updating performance: " + e.getMessage();
        }
    }

    public String deletePerformance(String performanceId) {
        try {
            service.deletePerformance(performanceId);
            return "Performance deleted successfully";
        } catch (Exception e) {
            return "Error deleting performance: " + e.getMessage();
        }
    }
}

