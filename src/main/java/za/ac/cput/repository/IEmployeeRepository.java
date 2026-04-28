package za.ac.cput.repository;

import za.ac.cput.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(String employeeId);
    List<Employee> findAll();
    void delete(String employeeId);
    boolean exists(String employeeId);
}

