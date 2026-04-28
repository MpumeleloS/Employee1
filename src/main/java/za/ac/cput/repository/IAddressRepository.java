package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import java.util.List;
import java.util.Optional;

public interface IAddressRepository {
    Address save(Address address);
    Optional<Address> findById(String addressId);
    List<Address> findAll();
    void delete(String addressId);
    boolean exists(String addressId);
}

