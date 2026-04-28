package za.ac.cput.service;

import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.repository.IEmployeeRepository;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final IEmployeeRepository repository;

    public EmployeeService() {
        this.repository = EmployeeRepository.getInstance();
    }

    public Employee createEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        return repository.save(employee);
    }

    public Employee getEmployeeById(String employeeId) {
        Optional<Employee> employee = repository.findById(employeeId);
        return employee.orElseThrow(() -> new RuntimeException("Employee not found: " + employeeId));
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (employee == null || !repository.exists(employee.getEmployeeId())) {
            throw new IllegalArgumentException("Employee not found");
        }
        return repository.save(employee);
    }

    public void deleteEmployee(String employeeId) {
        if (!repository.exists(employeeId)) {
            throw new IllegalArgumentException("Employee not found");
        }
        repository.delete(employeeId);
    }

    public boolean employeeExists(String employeeId) {
        return repository.exists(employeeId);
    }
}

