package za.ac.cput.repository;

import za.ac.cput.domain.Salary;
import java.util.*;
import java.util.stream.Collectors;

public class SalaryRepository implements ISalaryRepository {
    private static final Map<String, Salary> store = new HashMap<>();
    private static SalaryRepository instance;

    private SalaryRepository() {}

    public static synchronized SalaryRepository getInstance() {
        if (instance == null) {
            instance = new SalaryRepository();
        }
        return instance;
    }

    @Override
    public Salary save(Salary salary) {
        if (salary == null) {
            throw new IllegalArgumentException("Salary cannot be null");
        }
        store.put(salary.getSalaryId(), salary);
        return salary;
    }

    @Override
    public Optional<Salary> findById(String salaryId) {
        return Optional.ofNullable(store.get(salaryId));
    }

    @Override
    public List<Salary> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String salaryId) {
        store.remove(salaryId);
    }

    @Override
    public boolean exists(String salaryId) {
        return store.containsKey(salaryId);
    }

    @Override
    public List<Salary> findByEmployeeId(String employeeId) {
        return store.values().stream()
                .filter(s -> s.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());
    }
}

