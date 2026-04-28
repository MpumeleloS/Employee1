package za.ac.cput.service;

import za.ac.cput.domain.Salary;
import za.ac.cput.repository.SalaryRepository;
import za.ac.cput.repository.ISalaryRepository;
import java.util.List;
import java.util.Optional;

public class SalaryService {
    private final ISalaryRepository repository;

    public SalaryService() {
        this.repository = SalaryRepository.getInstance();
    }

    public Salary createSalary(Salary salary) {
        if (salary == null) {
            throw new IllegalArgumentException("Salary cannot be null");
        }
        return repository.save(salary);
    }

    public Salary getSalaryById(String salaryId) {
        Optional<Salary> salary = repository.findById(salaryId);
        return salary.orElseThrow(() -> new RuntimeException("Salary not found: " + salaryId));
    }

    public List<Salary> getAllSalaries() {
        return repository.findAll();
    }

    public List<Salary> getSalariesByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    public Salary updateSalary(Salary salary) {
        if (salary == null || !repository.exists(salary.getSalaryId())) {
            throw new IllegalArgumentException("Salary not found");
        }
        return repository.save(salary);
    }

    public void deleteSalary(String salaryId) {
        if (!repository.exists(salaryId)) {
            throw new IllegalArgumentException("Salary not found");
        }
        repository.delete(salaryId);
    }

    public boolean salaryExists(String salaryId) {
        return repository.exists(salaryId);
    }
}

