package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class LeaveTest {
    private Leave leave;

    @BeforeEach
    public void setUp() {
        leave = new Leave("L001", "E001", "Annual", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 10), "Approved", "Vacation");
    }

    @Test
    public void testLeaveCreation() {
        assertNotNull(leave);
        assertEquals("L001", leave.getLeaveId());
        assertEquals("E001", leave.getEmployeeId());
        assertEquals("Annual", leave.getLeaveType());
    }

    @Test
    public void testCalculateDays() {
        long days = leave.calculateDays();
        assertEquals(10, days);
    }

    @Test
    public void testLeaveSetters() {
        leave.setStatus("Rejected");
        assertEquals("Rejected", leave.getStatus());
    }

    @Test
    public void testLeaveEquality() {
        Leave leave2 = new Leave("L001", "E002", "Sick", LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 5), "Pending", "Medical");
        assertEquals(leave, leave2);
    }

    @Test
    public void testLeaveToString() {
        String result = leave.toString();
        assertNotNull(result);
        assertTrue(result.contains("L001"));
    }
}

