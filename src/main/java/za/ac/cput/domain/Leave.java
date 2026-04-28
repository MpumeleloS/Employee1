package za.ac.cput.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Leave implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String leaveId;
    private String employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String reason;

    public Leave(String leaveId, String employeeId, String leaveType, LocalDate startDate, LocalDate endDate, String status, String reason) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
    }

    public Leave() {}

    public String getLeaveId() { return leaveId; }
    public void setLeaveId(String leaveId) { this.leaveId = leaveId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public long calculateDays() {
        if (startDate != null && endDate != null) {
            return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate) + 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId='" + leaveId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", status='" + status + '\'' +
                ", days=" + calculateDays() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leave leave = (Leave) o;
        return leaveId != null && leaveId.equals(leave.leaveId);
    }

    @Override
    public int hashCode() {
        return leaveId != null ? leaveId.hashCode() : 0;
    }
}

