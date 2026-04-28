package za.ac.cput.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import java.time.LocalDate;

public class EmployeeControllerTest {
    private EmployeeController controller;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        controller = new EmployeeController();
        employee = EmployeeFactory.createEmployee("E001", "John", "Doe",
            LocalDate.of(1990, 5, 15), "john@example.com",
            LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");
    }

    @Test
    public void testCreateEmployee() {
        String result = controller.createEmployee(employee);
        assertNotNull(result);
        assertTrue(result.contains("successfully"));
    }

    @Test
    public void testGetEmployee() {
        controller.createEmployee(employee);
        String result = controller.getEmployee("E001");
        assertNotNull(result);
        assertTrue(result.contains("found"));
    }

    @Test
    public void testGetEmployeeNotFound() {
        String result = controller.getEmployee("E999");
        assertTrue(result.contains("Error"));
    }

    @Test
    public void testGetAllEmployees() {
        controller.createEmployee(employee);
        String result = controller.getAllEmployees();
        assertNotNull(result);
        assertTrue(result.contains("Total"));
    }

    @Test
    public void testUpdateEmployee() {
        controller.createEmployee(employee);
        employee.setFirstName("Jane");
        String result = controller.updateEmployee(employee);
        assertTrue(result.contains("successfully"));
    }

    @Test
    public void testDeleteEmployee() {
        controller.createEmployee(employee);
        String result = controller.deleteEmployee("E001");
        assertTrue(result.contains("successfully"));
    }
}

