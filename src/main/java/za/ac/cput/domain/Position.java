package za.ac.cput.domain;

import java.io.Serializable;

public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String positionId;
    private String positionTitle;
    private String description;
    private Double baseSalary;

    public Position(String positionId, String positionTitle, String description, Double baseSalary) {
        this.positionId = positionId;
        this.positionTitle = positionTitle;
        this.description = description;
        this.baseSalary = baseSalary;
    }

    public Position() {}

    public String getPositionId() { return positionId; }
    public void setPositionId(String positionId) { this.positionId = positionId; }

    public String getPositionTitle() { return positionTitle; }
    public void setPositionTitle(String positionTitle) { this.positionTitle = positionTitle; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(Double baseSalary) { this.baseSalary = baseSalary; }

    @Override
    public String toString() {
        return "Position{" +
                "positionId='" + positionId + '\'' +
                ", positionTitle='" + positionTitle + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionId != null && positionId.equals(position.positionId);
    }

    @Override
    public int hashCode() {
        return positionId != null ? positionId.hashCode() : 0;
    }
}

