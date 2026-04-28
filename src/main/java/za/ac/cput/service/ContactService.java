package za.ac.cput.service;

import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.repository.IContactRepository;
import java.util.List;
import java.util.Optional;

public class ContactService {
    private final IContactRepository repository;

    public ContactService() {
        this.repository = ContactRepository.getInstance();
    }

    public Contact createContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        return repository.save(contact);
    }

    public Contact getContactById(String contactId) {
        Optional<Contact> contact = repository.findById(contactId);
        return contact.orElseThrow(() -> new RuntimeException("Contact not found: " + contactId));
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact updateContact(Contact contact) {
        if (contact == null || !repository.exists(contact.getContactId())) {
            throw new IllegalArgumentException("Contact not found");
        }
        return repository.save(contact);
    }

    public void deleteContact(String contactId) {
        if (!repository.exists(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        repository.delete(contactId);
    }

    public boolean contactExists(String contactId) {
        return repository.exists(contactId);
    }
}

