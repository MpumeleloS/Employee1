package za.ac.cput.repository;

import za.ac.cput.domain.Salary;
import java.util.List;
import java.util.Optional;

public interface ISalaryRepository {
    Salary save(Salary salary);
    Optional<Salary> findById(String salaryId);
    List<Salary> findAll();
    void delete(String salaryId);
    boolean exists(String salaryId);
    List<Salary> findByEmployeeId(String employeeId);
}

