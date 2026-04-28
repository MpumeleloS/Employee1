package za.ac.cput.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("C001", "021-555-0123", "083-555-0456", "Jane Doe", "083-555-0789");
    }

    @Test
    public void testContactCreation() {
        assertNotNull(contact);
        assertEquals("C001", contact.getContactId());
        assertEquals("021-555-0123", contact.getPhoneNumber());
        assertEquals("083-555-0456", contact.getCellPhone());
    }

    @Test
    public void testContactSetters() {
        contact.setCellPhone("083-555-1111");
        assertEquals("083-555-1111", contact.getCellPhone());
    }

    @Test
    public void testContactEquality() {
        Contact contact2 = new Contact("C001", "021-555-9999", "083-555-8888", "John Smith", "083-555-7777");
        assertEquals(contact, contact2);
    }

    @Test
    public void testContactToString() {
        String result = contact.toString();
        assertNotNull(result);
        assertTrue(result.contains("C001"));
    }
}

