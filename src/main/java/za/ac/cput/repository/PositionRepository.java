package za.ac.cput.repository;

import za.ac.cput.domain.Position;
import java.util.*;

public class PositionRepository implements IPositionRepository {
    private static final Map<String, Position> store = new HashMap<>();
    private static PositionRepository instance;

    private PositionRepository() {}

    public static synchronized PositionRepository getInstance() {
        if (instance == null) {
            instance = new PositionRepository();
        }
        return instance;
    }

    @Override
    public Position save(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        store.put(position.getPositionId(), position);
        return position;
    }

    @Override
    public Optional<Position> findById(String positionId) {
        return Optional.ofNullable(store.get(positionId));
    }

    @Override
    public List<Position> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String positionId) {
        store.remove(positionId);
    }

    @Override
    public boolean exists(String positionId) {
        return store.containsKey(positionId);
    }
}

