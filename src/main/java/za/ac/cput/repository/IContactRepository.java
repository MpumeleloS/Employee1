package za.ac.cput.repository;

import za.ac.cput.domain.Contact;
import java.util.List;
import java.util.Optional;

public interface IContactRepository {
    Contact save(Contact contact);
    Optional<Contact> findById(String contactId);
    List<Contact> findAll();
    void delete(String contactId);
    boolean exists(String contactId);
}

