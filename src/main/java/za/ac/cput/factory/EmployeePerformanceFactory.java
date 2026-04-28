package za.ac.cput.factory;

import za.ac.cput.domain.EmployeePerformance;
import java.time.LocalDate;

public class EmployeePerformanceFactory {
    
    public static EmployeePerformance createEmployeePerformance(String performanceId, String employeeId, Double rating, String feedback, LocalDate reviewDate, String reviewerName) {
        if (performanceId == null || performanceId.isEmpty()) {
            throw new IllegalArgumentException("Performance ID cannot be null or empty");
        }
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        if (rating == null || rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        return new EmployeePerformance(performanceId, employeeId, rating, feedback, reviewDate, reviewerName);
    }

    public static EmployeePerformance createEmployeePerformance() {
        return new EmployeePerformance();
    }
}

