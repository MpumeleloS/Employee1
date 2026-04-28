package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EmployeeTest {
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("E001", "John", "Doe", 
            LocalDate.of(1990, 5, 15), "john@example.com",
            LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");
    }

    @Test
    public void testEmployeeCreation() {
        assertNotNull(employee);
        assertEquals("E001", employee.getEmployeeId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john@example.com", employee.getEmail());
    }

    @Test
    public void testEmployeeSetters() {
        employee.setFirstName("Jane");
        employee.setEmail("jane@example.com");
        assertEquals("Jane", employee.getFirstName());
        assertEquals("jane@example.com", employee.getEmail());
    }

    @Test
    public void testEmployeeEquality() {
        Employee employee2 = new Employee("E001", "Jane", "Smith", 
            LocalDate.of(1991, 3, 20), "jane@example.com",
            LocalDate.of(2021, 1, 15), "D001", "P001", "A001", "C001");
        assertEquals(employee, employee2);
    }

    @Test
    public void testEmployeeHashCode() {
        Employee employee2 = new Employee("E001", "Jane", "Smith", 
            LocalDate.of(1991, 3, 20), "jane@example.com",
            LocalDate.of(2021, 1, 15), "D001", "P001", "A001", "C001");
        assertEquals(employee.hashCode(), employee2.hashCode());
    }

    @Test
    public void testEmployeeToString() {
        String result = employee.toString();
        assertNotNull(result);
        assertTrue(result.contains("E001"));
        assertTrue(result.contains("John"));
    }
}

