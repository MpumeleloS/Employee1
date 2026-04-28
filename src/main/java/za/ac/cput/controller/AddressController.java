package za.ac.cput.controller;

import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;
import java.util.List;

public class AddressController {
    private final AddressService service;

    public AddressController() {
        this.service = new AddressService();
    }

    public String createAddress(Address address) {
        try {
            Address created = service.createAddress(address);
            return "Address created successfully: " + created.getAddressId();
        } catch (Exception e) {
            return "Error creating address: " + e.getMessage();
        }
    }

    public String getAddress(String addressId) {
        try {
            Address address = service.getAddressById(addressId);
            return "Address found: " + address.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllAddresses() {
        try {
            List<Address> addresses = service.getAllAddresses();
            return "Total addresses: " + addresses.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updateAddress(Address address) {
        try {
            Address updated = service.updateAddress(address);
            return "Address updated successfully";
        } catch (Exception e) {
            return "Error updating address: " + e.getMessage();
        }
    }

    public String deleteAddress(String addressId) {
        try {
            service.deleteAddress(addressId);
            return "Address deleted successfully";
        } catch (Exception e) {
            return "Error deleting address: " + e.getMessage();
        }
    }
}

