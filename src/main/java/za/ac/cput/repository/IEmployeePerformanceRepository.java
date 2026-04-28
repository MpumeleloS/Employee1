package za.ac.cput.repository;

import za.ac.cput.domain.EmployeePerformance;
import java.util.List;
import java.util.Optional;

public interface IEmployeePerformanceRepository {
    EmployeePerformance save(EmployeePerformance performance);
    Optional<EmployeePerformance> findById(String performanceId);
    List<EmployeePerformance> findAll();
    void delete(String performanceId);
    boolean exists(String performanceId);
    List<EmployeePerformance> findByEmployeeId(String employeeId);
}

