package za.ac.cput.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class HelperTest {

    @Test
    public void testGenerateId() {
        String id1 = Helper.generateId();
        String id2 = Helper.generateId();
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }

    @Test
    public void testCalculateAge() {
        int age = Helper.calculateAge(LocalDate.of(1990, 5, 15));
        assertTrue(age >= 33);
    }

    @Test
    public void testCalculateAgeNull() {
        int age = Helper.calculateAge(null);
        assertEquals(0, age);
    }

    @Test
    public void testIsValidEmail() {
        assertTrue(Helper.isValidEmail("john@example.com"));
        assertFalse(Helper.isValidEmail("invalid-email"));
        assertFalse(Helper.isValidEmail(null));
    }

    @Test
    public void testIsValidPhoneNumber() {
        assertTrue(Helper.isValidPhoneNumber("0215550123"));
        assertTrue(Helper.isValidPhoneNumber("+27215550123"));
        assertFalse(Helper.isValidPhoneNumber("123"));
    }

    @Test
    public void testCapitalizeFirstLetter() {
        assertEquals("John", Helper.capitalizeFirstLetter("john"));
        assertEquals("Jane", Helper.capitalizeFirstLetter("JANE"));
    }

    @Test
    public void testFormatCurrency() {
        String formatted = Helper.formatCurrency(1000.5);
        assertTrue(formatted.contains("R"));
        assertTrue(formatted.contains("1000"));
    }

    @Test
    public void testFormatCurrencyNull() {
        String formatted = Helper.formatCurrency(null);
        assertEquals("R0.00", formatted);
    }

    @Test
    public void testIsNullOrEmpty() {
        assertTrue(Helper.isNullOrEmpty(null));
        assertTrue(Helper.isNullOrEmpty(""));
        assertFalse(Helper.isNullOrEmpty("test"));
    }

    @Test
    public void testIsValidSalary() {
        assertTrue(Helper.isValidSalary(50000.0));
        assertFalse(Helper.isValidSalary(0.0));
        assertFalse(Helper.isValidSalary(-1000.0));
        assertFalse(Helper.isValidSalary(null));
    }

    @Test
    public void testDaysBetween() {
        long days = Helper.daysBetween(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 11));
        assertEquals(10, days);
    }

    @Test
    public void testIsFutureDate() {
        assertTrue(Helper.isFutureDate(LocalDate.now().plusDays(1)));
        assertFalse(Helper.isFutureDate(LocalDate.now().minusDays(1)));
    }

    @Test
    public void testIsPastDate() {
        assertTrue(Helper.isPastDate(LocalDate.now().minusDays(1)));
        assertFalse(Helper.isPastDate(LocalDate.now().plusDays(1)));
    }
}

