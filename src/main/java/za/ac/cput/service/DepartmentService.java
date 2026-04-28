package za.ac.cput.service;

import za.ac.cput.domain.Department;
import za.ac.cput.repository.DepartmentRepository;
import za.ac.cput.repository.IDepartmentRepository;
import java.util.List;
import java.util.Optional;

public class DepartmentService {
    private final IDepartmentRepository repository;

    public DepartmentService() {
        this.repository = DepartmentRepository.getInstance();
    }

    public Department createDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        return repository.save(department);
    }

    public Department getDepartmentById(String departmentId) {
        Optional<Department> department = repository.findById(departmentId);
        return department.orElseThrow(() -> new RuntimeException("Department not found: " + departmentId));
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department updateDepartment(Department department) {
        if (department == null || !repository.exists(department.getDepartmentId())) {
            throw new IllegalArgumentException("Department not found");
        }
        return repository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        if (!repository.exists(departmentId)) {
            throw new IllegalArgumentException("Department not found");
        }
        repository.delete(departmentId);
    }

    public boolean departmentExists(String departmentId) {
        return repository.exists(departmentId);
    }
}

