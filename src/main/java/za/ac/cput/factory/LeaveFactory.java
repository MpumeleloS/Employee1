package za.ac.cput.factory;

import za.ac.cput.domain.Leave;
import java.time.LocalDate;

public class LeaveFactory {
    
    public static Leave createLeave(String leaveId, String employeeId, String leaveType, LocalDate startDate, LocalDate endDate, String status, String reason) {
        if (leaveId == null || leaveId.isEmpty()) {
            throw new IllegalArgumentException("Leave ID cannot be null or empty");
        }
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        if (leaveType == null || leaveType.isEmpty()) {
            throw new IllegalArgumentException("Leave type cannot be null or empty");
        }
        return new Leave(leaveId, employeeId, leaveType, startDate, endDate, status, reason);
    }

    public static Leave createLeave() {
        return new Leave();
    }
}

