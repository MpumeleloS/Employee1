package za.ac.cput.service;

import za.ac.cput.domain.EmployeePerformance;
import za.ac.cput.repository.EmployeePerformanceRepository;
import za.ac.cput.repository.IEmployeePerformanceRepository;
import java.util.List;
import java.util.Optional;

public class EmployeePerformanceService {
    private final IEmployeePerformanceRepository repository;

    public EmployeePerformanceService() {
        this.repository = EmployeePerformanceRepository.getInstance();
    }

    public EmployeePerformance createPerformance(EmployeePerformance performance) {
        if (performance == null) {
            throw new IllegalArgumentException("Performance cannot be null");
        }
        return repository.save(performance);
    }

    public EmployeePerformance getPerformanceById(String performanceId) {
        Optional<EmployeePerformance> performance = repository.findById(performanceId);
        return performance.orElseThrow(() -> new RuntimeException("Performance not found: " + performanceId));
    }

    public List<EmployeePerformance> getAllPerformances() {
        return repository.findAll();
    }

    public List<EmployeePerformance> getPerformancesByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    public EmployeePerformance updatePerformance(EmployeePerformance performance) {
        if (performance == null || !repository.exists(performance.getPerformanceId())) {
            throw new IllegalArgumentException("Performance not found");
        }
        return repository.save(performance);
    }

    public void deletePerformance(String performanceId) {
        if (!repository.exists(performanceId)) {
            throw new IllegalArgumentException("Performance not found");
        }
        repository.delete(performanceId);
    }

    public boolean performanceExists(String performanceId) {
        return repository.exists(performanceId);
    }
}

