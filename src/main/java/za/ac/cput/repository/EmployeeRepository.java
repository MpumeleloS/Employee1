package za.ac.cput.repository;

import za.ac.cput.domain.Employee;
import java.util.*;

public class EmployeeRepository implements IEmployeeRepository {
    private static final Map<String, Employee> store = new HashMap<>();
    private static EmployeeRepository instance;

    private EmployeeRepository() {}

    public static synchronized EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public Employee save(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        store.put(employee.getEmployeeId(), employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        return Optional.ofNullable(store.get(employeeId));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String employeeId) {
        store.remove(employeeId);
    }

    @Override
    public boolean exists(String employeeId) {
        return store.containsKey(employeeId);
    }
}

