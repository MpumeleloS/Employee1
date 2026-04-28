package za.ac.cput.repository;

import za.ac.cput.domain.EmployeePerformance;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeePerformanceRepository implements IEmployeePerformanceRepository {
    private static final Map<String, EmployeePerformance> store = new HashMap<>();
    private static EmployeePerformanceRepository instance;

    private EmployeePerformanceRepository() {}

    public static synchronized EmployeePerformanceRepository getInstance() {
        if (instance == null) {
            instance = new EmployeePerformanceRepository();
        }
        return instance;
    }

    @Override
    public EmployeePerformance save(EmployeePerformance performance) {
        if (performance == null) {
            throw new IllegalArgumentException("Performance cannot be null");
        }
        store.put(performance.getPerformanceId(), performance);
        return performance;
    }

    @Override
    public Optional<EmployeePerformance> findById(String performanceId) {
        return Optional.ofNullable(store.get(performanceId));
    }

    @Override
    public List<EmployeePerformance> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String performanceId) {
        store.remove(performanceId);
    }

    @Override
    public boolean exists(String performanceId) {
        return store.containsKey(performanceId);
    }

    @Override
    public List<EmployeePerformance> findByEmployeeId(String employeeId) {
        return store.values().stream()
                .filter(p -> p.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());
    }
}

