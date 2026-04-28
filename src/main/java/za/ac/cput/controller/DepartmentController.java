package za.ac.cput.controller;

import za.ac.cput.domain.Department;
import za.ac.cput.service.DepartmentService;
import java.util.List;

public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController() {
        this.service = new DepartmentService();
    }

    public String createDepartment(Department department) {
        try {
            Department created = service.createDepartment(department);
            return "Department created successfully: " + created.getDepartmentId();
        } catch (Exception e) {
            return "Error creating department: " + e.getMessage();
        }
    }

    public String getDepartment(String departmentId) {
        try {
            Department department = service.getDepartmentById(departmentId);
            return "Department found: " + department.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllDepartments() {
        try {
            List<Department> departments = service.getAllDepartments();
            return "Total departments: " + departments.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updateDepartment(Department department) {
        try {
            Department updated = service.updateDepartment(department);
            return "Department updated successfully";
        } catch (Exception e) {
            return "Error updating department: " + e.getMessage();
        }
    }

    public String deleteDepartment(String departmentId) {
        try {
            service.deleteDepartment(departmentId);
            return "Department deleted successfully";
        } catch (Exception e) {
            return "Error deleting department: " + e.getMessage();
        }
    }
}

