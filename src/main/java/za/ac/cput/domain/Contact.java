package za.ac.cput.domain;

import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String contactId;
    private String phoneNumber;
    private String cellPhone;
    private String emergencyContact;
    private String emergencyPhoneNumber;

    public Contact(String contactId, String phoneNumber, String cellPhone, String emergencyContact, String emergencyPhoneNumber) {
        this.contactId = contactId;
        this.phoneNumber = phoneNumber;
        this.cellPhone = cellPhone;
        this.emergencyContact = emergencyContact;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public Contact() {}

    public String getContactId() { return contactId; }
    public void setContactId(String contactId) { this.contactId = contactId; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getCellPhone() { return cellPhone; }
    public void setCellPhone(String cellPhone) { this.cellPhone = cellPhone; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getEmergencyPhoneNumber() { return emergencyPhoneNumber; }
    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) { this.emergencyPhoneNumber = emergencyPhoneNumber; }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return contactId != null && contactId.equals(contact.contactId);
    }

    @Override
    public int hashCode() {
        return contactId != null ? contactId.hashCode() : 0;
    }
}

