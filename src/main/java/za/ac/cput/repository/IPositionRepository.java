package za.ac.cput.repository;

import za.ac.cput.domain.Position;
import java.util.List;
import java.util.Optional;

public interface IPositionRepository {
    Position save(Position position);
    Optional<Position> findById(String positionId);
    List<Position> findAll();
    void delete(String positionId);
    boolean exists(String positionId);
}

