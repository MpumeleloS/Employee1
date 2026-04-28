package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.repository.IAddressRepository;
import java.util.List;
import java.util.Optional;

public class AddressService {
    private final IAddressRepository repository;

    public AddressService() {
        this.repository = AddressRepository.getInstance();
    }

    public Address createAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        return repository.save(address);
    }

    public Address getAddressById(String addressId) {
        Optional<Address> address = repository.findById(addressId);
        return address.orElseThrow(() -> new RuntimeException("Address not found: " + addressId));
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public Address updateAddress(Address address) {
        if (address == null || !repository.exists(address.getAddressId())) {
            throw new IllegalArgumentException("Address not found");
        }
        return repository.save(address);
    }

    public void deleteAddress(String addressId) {
        if (!repository.exists(addressId)) {
            throw new IllegalArgumentException("Address not found");
        }
        repository.delete(addressId);
    }

    public boolean addressExists(String addressId) {
        return repository.exists(addressId);
    }
}

