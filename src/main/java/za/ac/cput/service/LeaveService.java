package za.ac.cput.service;

import za.ac.cput.domain.Leave;
import za.ac.cput.repository.LeaveRepository;
import za.ac.cput.repository.ILeaveRepository;
import java.util.List;
import java.util.Optional;

public class LeaveService {
    private final ILeaveRepository repository;

    public LeaveService() {
        this.repository = LeaveRepository.getInstance();
    }

    public Leave createLeave(Leave leave) {
        if (leave == null) {
            throw new IllegalArgumentException("Leave cannot be null");
        }
        return repository.save(leave);
    }

    public Leave getLeaveById(String leaveId) {
        Optional<Leave> leave = repository.findById(leaveId);
        return leave.orElseThrow(() -> new RuntimeException("Leave not found: " + leaveId));
    }

    public List<Leave> getAllLeaves() {
        return repository.findAll();
    }

    public List<Leave> getLeavesByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    public Leave updateLeave(Leave leave) {
        if (leave == null || !repository.exists(leave.getLeaveId())) {
            throw new IllegalArgumentException("Leave not found");
        }
        return repository.save(leave);
    }

    public void deleteLeave(String leaveId) {
        if (!repository.exists(leaveId)) {
            throw new IllegalArgumentException("Leave not found");
        }
        repository.delete(leaveId);
    }

    public boolean leaveExists(String leaveId) {
        return repository.exists(leaveId);
    }
}

