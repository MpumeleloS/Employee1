package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EmployeePerformanceTest {
    private EmployeePerformance performance;

    @BeforeEach
    public void setUp() {
        performance = new EmployeePerformance("PERF001", "E001", 4.5, "Excellent performance", LocalDate.of(2024, 3, 15), "Manager A");
    }

    @Test
    public void testPerformanceCreation() {
        assertNotNull(performance);
        assertEquals("PERF001", performance.getPerformanceId());
        assertEquals("E001", performance.getEmployeeId());
        assertEquals(4.5, performance.getRating());
    }

    @Test
    public void testGetPerformanceLevel() {
        String level = performance.getPerformanceLevel();
        assertEquals("EXCELLENT", level);
    }

    @Test
    public void testGetPerformanceLevelGood() {
        performance.setRating(3.5);
        assertEquals("GOOD", performance.getPerformanceLevel());
    }

    @Test
    public void testPerformanceSetters() {
        performance.setRating(3.0);
        assertEquals(3.0, performance.getRating());
    }

    @Test
    public void testPerformanceEquality() {
        EmployeePerformance perf2 = new EmployeePerformance("PERF001", "E002", 3.8, "Good", LocalDate.of(2024, 3, 20), "Manager B");
        assertEquals(performance, perf2);
    }

    @Test
    public void testPerformanceToString() {
        String result = performance.toString();
        assertNotNull(result);
        assertTrue(result.contains("PERF001"));
    }
}

