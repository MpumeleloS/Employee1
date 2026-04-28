package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class SalaryTest {
    private Salary salary;

    @BeforeEach
    public void setUp() {
        salary = new Salary("S001", "E001", 75000.0, 5000.0, 2000.0, LocalDate.of(2024, 1, 1));
    }

    @Test
    public void testSalaryCreation() {
        assertNotNull(salary);
        assertEquals("S001", salary.getSalaryId());
        assertEquals("E001", salary.getEmployeeId());
        assertEquals(75000.0, salary.getBaseSalary());
    }

    @Test
    public void testCalculateNetSalary() {
        Double netSalary = salary.calculateNetSalary();
        assertEquals(78000.0, netSalary);
    }

    @Test
    public void testSalarySetters() {
        salary.setBaseSalary(80000.0);
        assertEquals(80000.0, salary.getBaseSalary());
    }

    @Test
    public void testSalaryEquality() {
        Salary salary2 = new Salary("S001", "E002", 80000.0, 6000.0, 2500.0, LocalDate.of(2024, 1, 1));
        assertEquals(salary, salary2);
    }

    @Test
    public void testSalaryToString() {
        String result = salary.toString();
        assertNotNull(result);
        assertTrue(result.contains("S001"));
    }
}

