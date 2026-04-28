package za.ac.cput.factory;

import za.ac.cput.domain.Address;

public class AddressFactory {
    
    public static Address createAddress(String addressId, String street, String city, String province, String zipCode, String country) {
        if (addressId == null || addressId.isEmpty()) {
            throw new IllegalArgumentException("Address ID cannot be null or empty");
        }
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        return new Address(addressId, street, city, province, zipCode, country);
    }

    public static Address createAddress() {
        return new Address();
    }
}

