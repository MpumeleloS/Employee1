package za.ac.cput.factory;

import za.ac.cput.domain.Department;

public class DepartmentFactory {
    
    public static Department createDepartment(String departmentId, String departmentName, String description, String managerId) {
        if (departmentId == null || departmentId.isEmpty()) {
            throw new IllegalArgumentException("Department ID cannot be null or empty");
        }
        if (departmentName == null || departmentName.isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty");
        }
        return new Department(departmentId, departmentName, description, managerId);
    }

    public static Department createDepartment() {
        return new Department();
    }
}

