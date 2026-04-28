package za.ac.cput.domain;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String addressId;
    private String street;
    private String city;
    private String province;
    private String zipCode;
    private String country;

    public Address(String addressId, String street, String city, String province, String zipCode, String country) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Address() {}

    public String getAddressId() { return addressId; }
    public void setAddressId(String addressId) { this.addressId = addressId; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId != null && addressId.equals(address.addressId);
    }

    @Override
    public int hashCode() {
        return addressId != null ? addressId.hashCode() : 0;
    }
}

