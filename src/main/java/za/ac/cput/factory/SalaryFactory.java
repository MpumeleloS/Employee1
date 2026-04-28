package za.ac.cput.factory;

import za.ac.cput.domain.Salary;
import java.time.LocalDate;

public class SalaryFactory {
    
    public static Salary createSalary(String salaryId, String employeeId, Double baseSalary, Double bonus, Double deductions, LocalDate effectiveDate) {
        if (salaryId == null || salaryId.isEmpty()) {
            throw new IllegalArgumentException("Salary ID cannot be null or empty");
        }
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        if (baseSalary == null || baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than 0");
        }
        return new Salary(salaryId, employeeId, baseSalary, bonus, deductions, effectiveDate);
    }

    public static Salary createSalary() {
        return new Salary();
    }
}

