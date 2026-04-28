package za.ac.cput.repository;

import za.ac.cput.domain.Department;
import java.util.*;

public class DepartmentRepository implements IDepartmentRepository {
    private static final Map<String, Department> store = new HashMap<>();
    private static DepartmentRepository instance;

    private DepartmentRepository() {}

    public static synchronized DepartmentRepository getInstance() {
        if (instance == null) {
            instance = new DepartmentRepository();
        }
        return instance;
    }

    @Override
    public Department save(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        store.put(department.getDepartmentId(), department);
        return department;
    }

    @Override
    public Optional<Department> findById(String departmentId) {
        return Optional.ofNullable(store.get(departmentId));
    }

    @Override
    public List<Department> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String departmentId) {
        store.remove(departmentId);
    }

    @Override
    public boolean exists(String departmentId) {
        return store.containsKey(departmentId);
    }
}

