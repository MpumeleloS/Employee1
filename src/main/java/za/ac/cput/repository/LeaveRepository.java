package za.ac.cput.repository;

import za.ac.cput.domain.Leave;
import java.util.*;
import java.util.stream.Collectors;

public class LeaveRepository implements ILeaveRepository {
    private static final Map<String, Leave> store = new HashMap<>();
    private static LeaveRepository instance;

    private LeaveRepository() {}

    public static synchronized LeaveRepository getInstance() {
        if (instance == null) {
            instance = new LeaveRepository();
        }
        return instance;
    }

    @Override
    public Leave save(Leave leave) {
        if (leave == null) {
            throw new IllegalArgumentException("Leave cannot be null");
        }
        store.put(leave.getLeaveId(), leave);
        return leave;
    }

    @Override
    public Optional<Leave> findById(String leaveId) {
        return Optional.ofNullable(store.get(leaveId));
    }

    @Override
    public List<Leave> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String leaveId) {
        store.remove(leaveId);
    }

    @Override
    public boolean exists(String leaveId) {
        return store.containsKey(leaveId);
    }

    @Override
    public List<Leave> findByEmployeeId(String employeeId) {
        return store.values().stream()
                .filter(l -> l.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());
    }
}

