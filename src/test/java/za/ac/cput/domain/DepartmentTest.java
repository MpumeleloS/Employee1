package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    private Department department;

    @BeforeEach
    public void setUp() {
        department = new Department("D001", "IT", "Information Technology Department", "E001");
    }

    @Test
    public void testDepartmentCreation() {
        assertNotNull(department);
        assertEquals("D001", department.getDepartmentId());
        assertEquals("IT", department.getDepartmentName());
        assertEquals("Information Technology Department", department.getDescription());
    }

    @Test
    public void testDepartmentSetters() {
        department.setDepartmentName("Human Resources");
        assertEquals("Human Resources", department.getDepartmentName());
    }

    @Test
    public void testDepartmentEquality() {
        Department department2 = new Department("D001", "HR", "HR Department", "E002");
        assertEquals(department, department2);
    }

    @Test
    public void testDepartmentToString() {
        String result = department.toString();
        assertNotNull(result);
        assertTrue(result.contains("D001"));
        assertTrue(result.contains("IT"));
    }
}

