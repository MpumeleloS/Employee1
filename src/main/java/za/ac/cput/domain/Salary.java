package za.ac.cput.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String salaryId;
    private String employeeId;
    private Double baseSalary;
    private Double bonus;
    private Double deductions;
    private LocalDate effectiveDate;

    public Salary(String salaryId, String employeeId, Double baseSalary, Double bonus, Double deductions, LocalDate effectiveDate) {
        this.salaryId = salaryId;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.deductions = deductions;
        this.effectiveDate = effectiveDate;
    }

    public Salary() {}

    public String getSalaryId() { return salaryId; }
    public void setSalaryId(String salaryId) { this.salaryId = salaryId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public Double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(Double baseSalary) { this.baseSalary = baseSalary; }

    public Double getBonus() { return bonus; }
    public void setBonus(Double bonus) { this.bonus = bonus; }

    public Double getDeductions() { return deductions; }
    public void setDeductions(Double deductions) { this.deductions = deductions; }

    public LocalDate getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }

    public Double calculateNetSalary() {
        return baseSalary + bonus - deductions;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId='" + salaryId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", baseSalary=" + baseSalary +
                ", netSalary=" + calculateNetSalary() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return salaryId != null && salaryId.equals(salary.salaryId);
    }

    @Override
    public int hashCode() {
        return salaryId != null ? salaryId.hashCode() : 0;
    }
}

