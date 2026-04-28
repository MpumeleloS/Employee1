package za.ac.cput.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceTest {
    private EmployeeService service;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        service = new EmployeeService();
        employee = EmployeeFactory.createEmployee("E001", "John", "Doe",
            LocalDate.of(1990, 5, 15), "john@example.com",
            LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");
        service.createEmployee(employee);
    }

    @Test
    public void testCreateEmployee() {
        Employee result = service.createEmployee(employee);
        assertNotNull(result);
        assertEquals("E001", result.getEmployeeId());
    }

    @Test
    public void testGetEmployeeById() {
        Employee result = service.getEmployeeById("E001");
        assertNotNull(result);
        assertEquals("E001", result.getEmployeeId());
    }

    @Test
    public void testGetEmployeeByIdNotFound() {
        assertThrows(RuntimeException.class, () -> service.getEmployeeById("E999"));
    }

    @Test
    public void testEmployeeExists() {
        boolean exists = service.employeeExists("E001");
        assertTrue(exists);
    }

    @Test
    public void testEmployeeDoesNotExist() {
        boolean exists = service.employeeExists("E999");
        assertFalse(exists);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        assertNotNull(employees);
        assertTrue(employees.size() > 0);
    }

    @Test
    public void testUpdateEmployee() {
        employee.setFirstName("Jane");
        Employee result = service.updateEmployee(employee);
        assertEquals("Jane", result.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        service.deleteEmployee("E001");
        assertFalse(service.employeeExists("E001"));
    }
}

