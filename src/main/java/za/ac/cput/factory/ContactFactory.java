package za.ac.cput.factory;

import za.ac.cput.domain.Contact;

public class ContactFactory {
    
    public static Contact createContact(String contactId, String phoneNumber, String cellPhone, String emergencyContact, String emergencyPhoneNumber) {
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty");
        }
        if (cellPhone == null || cellPhone.isEmpty()) {
            throw new IllegalArgumentException("Cell phone cannot be null or empty");
        }
        return new Contact(contactId, phoneNumber, cellPhone, emergencyContact, emergencyPhoneNumber);
    }

    public static Contact createContact() {
        return new Contact();
    }
}

