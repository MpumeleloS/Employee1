package za.ac.cput.controller;

import za.ac.cput.domain.Leave;
import za.ac.cput.service.LeaveService;
import java.util.List;

public class LeaveController {
    private final LeaveService service;

    public LeaveController() {
        this.service = new LeaveService();
    }

    public String createLeave(Leave leave) {
        try {
            Leave created = service.createLeave(leave);
            return "Leave created successfully: " + created.getLeaveId();
        } catch (Exception e) {
            return "Error creating leave: " + e.getMessage();
        }
    }

    public String getLeave(String leaveId) {
        try {
            Leave leave = service.getLeaveById(leaveId);
            return "Leave found: " + leave.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllLeaves() {
        try {
            List<Leave> leaves = service.getAllLeaves();
            return "Total leaves: " + leaves.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getLeavesByEmployee(String employeeId) {
        try {
            List<Leave> leaves = service.getLeavesByEmployeeId(employeeId);
            return "Employee leaves: " + leaves.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updateLeave(Leave leave) {
        try {
            Leave updated = service.updateLeave(leave);
            return "Leave updated successfully";
        } catch (Exception e) {
            return "Error updating leave: " + e.getMessage();
        }
    }

    public String deleteLeave(String leaveId) {
        try {
            service.deleteLeave(leaveId);
            return "Leave deleted successfully";
        } catch (Exception e) {
            return "Error deleting leave: " + e.getMessage();
        }
    }
}

