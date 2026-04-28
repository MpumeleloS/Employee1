package za.ac.cput.controller;

import za.ac.cput.domain.Position;
import za.ac.cput.service.PositionService;
import java.util.List;

public class PositionController {
    private final PositionService service;

    public PositionController() {
        this.service = new PositionService();
    }

    public String createPosition(Position position) {
        try {
            Position created = service.createPosition(position);
            return "Position created successfully: " + created.getPositionId();
        } catch (Exception e) {
            return "Error creating position: " + e.getMessage();
        }
    }

    public String getPosition(String positionId) {
        try {
            Position position = service.getPositionById(positionId);
            return "Position found: " + position.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAllPositions() {
        try {
            List<Position> positions = service.getAllPositions();
            return "Total positions: " + positions.size();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String updatePosition(Position position) {
        try {
            Position updated = service.updatePosition(position);
            return "Position updated successfully";
        } catch (Exception e) {
            return "Error updating position: " + e.getMessage();
        }
    }

    public String deletePosition(String positionId) {
        try {
            service.deletePosition(positionId);
            return "Position deleted successfully";
        } catch (Exception e) {
            return "Error deleting position: " + e.getMessage();
        }
    }
}

