package za.ac.cput.controller;

import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;
import java.util.List;

public class ContactController {
    private final ContactService service;

    public ContactController() {
        this.service = new ContactService();
    }

    public String createContact(Contact contact) {
        try {
            Contact created = service.createContact(contact);
            return "Contact created successfully: " + created.getContactId();
        } catch (Exception e) {
            return "Error creating contact: " + e.getMessage();
        }
    }

    public String getContact(String contactId) {
        try {
            Contact contact = service.getContactById(contactId);
            return "Contact found: " + contact.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllContacts() {
        try {
            List<Contact> contacts = service.getAllContacts();
            return "Total contacts: " + contacts.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updateContact(Contact contact) {
        try {
            Contact updated = service.updateContact(contact);
            return "Contact updated successfully";
        } catch (Exception e) {
            return "Error updating contact: " + e.getMessage();
        }
    }

    public String deleteContact(String contactId) {
        try {
            service.deleteContact(contactId);
            return "Contact deleted successfully";
        } catch (Exception e) {
            return "Error deleting contact: " + e.getMessage();
        }
    }
}

