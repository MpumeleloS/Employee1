package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("A001", "123 Main Street", "Cape Town", "Western Cape", "8000", "South Africa");
    }

    @Test
    public void testAddressCreation() {
        assertNotNull(address);
        assertEquals("A001", address.getAddressId());
        assertEquals("123 Main Street", address.getStreet());
        assertEquals("Cape Town", address.getCity());
    }

    @Test
    public void testAddressSetters() {
        address.setCity("Johannesburg");
        assertEquals("Johannesburg", address.getCity());
    }

    @Test
    public void testAddressEquality() {
        Address address2 = new Address("A001", "456 Other Street", "Durban", "KwaZulu-Natal", "4000", "South Africa");
        assertEquals(address, address2);
    }

    @Test
    public void testAddressToString() {
        String result = address.toString();
        assertNotNull(result);
        assertTrue(result.contains("A001"));
        assertTrue(result.contains("Cape Town"));
    }
}

