package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import java.time.LocalDate;

public class EmployeeFactoryTest {

    @Test
    public void testCreateEmployeeWithValidData() {
        Employee employee = EmployeeFactory.createEmployee("E001", "John", "Doe",
            LocalDate.of(1990, 5, 15), "john@example.com",
            LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");
        
        assertNotNull(employee);
        assertEquals("E001", employee.getEmployeeId());
    }

    @Test
    public void testCreateEmployeeWithNullId() {
        assertThrows(IllegalArgumentException.class, () ->
            EmployeeFactory.createEmployee(null, "John", "Doe",
                LocalDate.of(1990, 5, 15), "john@example.com",
                LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001")
        );
    }

    @Test
    public void testCreateEmployeeWithEmptyFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
            EmployeeFactory.createEmployee("E001", "", "Doe",
                LocalDate.of(1990, 5, 15), "john@example.com",
                LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001")
        );
    }

    @Test
    public void testCreateEmployeeWithNullEmail() {
        assertThrows(IllegalArgumentException.class, () ->
            EmployeeFactory.createEmployee("E001", "John", "Doe",
                LocalDate.of(1990, 5, 15), null,
                LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001")
        );
    }

    @Test
    public void testCreateEmptyEmployee() {
        Employee employee = EmployeeFactory.createEmployee();
        assertNotNull(employee);
    }
}

