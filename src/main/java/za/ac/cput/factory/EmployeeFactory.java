package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import java.time.LocalDate;

public class EmployeeFactory {
    
    public static Employee createEmployee(String employeeId, String firstName, String lastName, LocalDate dateOfBirth,
                                         String email, LocalDate hireDate, String departmentId, String positionId,
                                         String addressId, String contactId) {
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return new Employee(employeeId, firstName, lastName, dateOfBirth, email, hireDate, departmentId, positionId, addressId, contactId);
    }

    public static Employee createEmployee() {
        return new Employee();
    }
}

