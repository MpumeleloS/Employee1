package za.ac.cput.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private LocalDate hireDate;
    private String departmentId;
    private String positionId;
    private String addressId;
    private String contactId;

    public Employee(String employeeId, String firstName, String lastName, LocalDate dateOfBirth,
                    String email, LocalDate hireDate, String departmentId, String positionId,
                    String addressId, String contactId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.addressId = addressId;
        this.contactId = contactId;
    }

    public Employee() {}

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

    public String getPositionId() { return positionId; }
    public void setPositionId(String positionId) { this.positionId = positionId; }

    public String getAddressId() { return addressId; }
    public void setAddressId(String addressId) { this.addressId = addressId; }

    public String getContactId() { return contactId; }
    public void setContactId(String contactId) { this.contactId = contactId; }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId != null && employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return employeeId != null ? employeeId.hashCode() : 0;
    }
}

