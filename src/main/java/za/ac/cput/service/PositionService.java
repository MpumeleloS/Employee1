package za.ac.cput.service;

import za.ac.cput.domain.Position;
import za.ac.cput.repository.PositionRepository;
import za.ac.cput.repository.IPositionRepository;
import java.util.List;
import java.util.Optional;

public class PositionService {
    private final IPositionRepository repository;

    public PositionService() {
        this.repository = PositionRepository.getInstance();
    }

    public Position createPosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        return repository.save(position);
    }

    public Position getPositionById(String positionId) {
        Optional<Position> position = repository.findById(positionId);
        return position.orElseThrow(() -> new RuntimeException("Position not found: " + positionId));
    }

    public List<Position> getAllPositions() {
        return repository.findAll();
    }

    public Position updatePosition(Position position) {
        if (position == null || !repository.exists(position.getPositionId())) {
            throw new IllegalArgumentException("Position not found");
        }
        return repository.save(position);
    }

    public void deletePosition(String positionId) {
        if (!repository.exists(positionId)) {
            throw new IllegalArgumentException("Position not found");
        }
        repository.delete(positionId);
    }

    public boolean positionExists(String positionId) {
        return repository.exists(positionId);
    }
}

