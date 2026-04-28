package za.ac.cput.repository;

import za.ac.cput.domain.Leave;
import java.util.List;
import java.util.Optional;

public interface ILeaveRepository {
    Leave save(Leave leave);
    Optional<Leave> findById(String leaveId);
    List<Leave> findAll();
    void delete(String leaveId);
    boolean exists(String leaveId);
    List<Leave> findByEmployeeId(String employeeId);
}

