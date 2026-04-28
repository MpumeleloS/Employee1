package za.ac.cput.repository;

import za.ac.cput.domain.Contact;
import java.util.*;

public class ContactRepository implements IContactRepository {
    private static final Map<String, Contact> store = new HashMap<>();
    private static ContactRepository instance;

    private ContactRepository() {}

    public static synchronized ContactRepository getInstance() {
        if (instance == null) {
            instance = new ContactRepository();
        }
        return instance;
    }

    @Override
    public Contact save(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        store.put(contact.getContactId(), contact);
        return contact;
    }

    @Override
    public Optional<Contact> findById(String contactId) {
        return Optional.ofNullable(store.get(contactId));
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String contactId) {
        store.remove(contactId);
    }

    @Override
    public boolean exists(String contactId) {
        return store.containsKey(contactId);
    }
}

