package za.ac.cput.domain;

import java.io.Serializable;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String departmentId;
    private String departmentName;
    private String description;
    private String managerId;

    public Department(String departmentId, String departmentName, String description, String managerId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
        this.managerId = managerId;
    }

    public Department() {}

    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getManagerId() { return managerId; }
    public void setManagerId(String managerId) { this.managerId = managerId; }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId != null && departmentId.equals(that.departmentId);
    }

    @Override
    public int hashCode() {
        return departmentId != null ? departmentId.hashCode() : 0;
    }
}

