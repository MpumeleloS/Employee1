package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import java.time.LocalDate;
import java.util.Optional;

public class EmployeeRepositoryTest {
    private EmployeeRepository repository;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        repository = EmployeeRepository.getInstance();
        employee = EmployeeFactory.createEmployee("E001", "John", "Doe",
            LocalDate.of(1990, 5, 15), "john@example.com",
            LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");
        repository.save(employee);
    }

    @Test
    public void testSaveEmployee() {
        Employee result = repository.save(employee);
        assertNotNull(result);
        assertEquals("E001", result.getEmployeeId());
    }

    @Test
    public void testFindEmployeeById() {
        Optional<Employee> result = repository.findById("E001");
        assertTrue(result.isPresent());
        assertEquals("E001", result.get().getEmployeeId());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Employee> result = repository.findById("E999");
        assertFalse(result.isPresent());
    }

    @Test
    public void testEmployeeExists() {
        boolean exists = repository.exists("E001");
        assertTrue(exists);
    }

    @Test
    public void testEmployeeDoesNotExist() {
        boolean exists = repository.exists("E999");
        assertFalse(exists);
    }

    @Test
    public void testDeleteEmployee() {
        repository.delete("E001");
        assertFalse(repository.exists("E001"));
    }

    @Test
    public void testFindAllEmployees() {
        int count = repository.findAll().size();
        assertTrue(count > 0);
    }
}

