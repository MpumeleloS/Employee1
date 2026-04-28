package za.ac.cput.repository;

import za.ac.cput.domain.Department;
import java.util.List;
import java.util.Optional;

public interface IDepartmentRepository {
    Department save(Department department);
    Optional<Department> findById(String departmentId);
    List<Department> findAll();
    void delete(String departmentId);
    boolean exists(String departmentId);
}

