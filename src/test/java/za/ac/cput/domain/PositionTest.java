package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void setUp() {
        position = new Position("P001", "Software Developer", "Development Role", 75000.0);
    }

    @Test
    public void testPositionCreation() {
        assertNotNull(position);
        assertEquals("P001", position.getPositionId());
        assertEquals("Software Developer", position.getPositionTitle());
        assertEquals(75000.0, position.getBaseSalary());
    }

    @Test
    public void testPositionSetters() {
        position.setBaseSalary(80000.0);
        assertEquals(80000.0, position.getBaseSalary());
    }

    @Test
    public void testPositionEquality() {
        Position position2 = new Position("P001", "Senior Developer", "Senior Role", 90000.0);
        assertEquals(position, position2);
    }

    @Test
    public void testPositionToString() {
        String result = position.toString();
        assertNotNull(result);
        assertTrue(result.contains("P001"));
        assertTrue(result.contains("Software Developer"));
    }
}

