package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import java.util.*;

public class AddressRepository implements IAddressRepository {
    private static final Map<String, Address> store = new HashMap<>();
    private static AddressRepository instance;

    private AddressRepository() {}

    public static synchronized AddressRepository getInstance() {
        if (instance == null) {
            instance = new AddressRepository();
        }
        return instance;
    }

    @Override
    public Address save(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        store.put(address.getAddressId(), address);
        return address;
    }

    @Override
    public Optional<Address> findById(String addressId) {
        return Optional.ofNullable(store.get(addressId));
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String addressId) {
        store.remove(addressId);
    }

    @Override
    public boolean exists(String addressId) {
        return store.containsKey(addressId);
    }
}

