package za.ac.cput.factory;

import za.ac.cput.domain.Position;

public class PositionFactory {
    
    public static Position createPosition(String positionId, String positionTitle, String description, Double baseSalary) {
        if (positionId == null || positionId.isEmpty()) {
            throw new IllegalArgumentException("Position ID cannot be null or empty");
        }
        if (positionTitle == null || positionTitle.isEmpty()) {
            throw new IllegalArgumentException("Position title cannot be null or empty");
        }
        if (baseSalary == null || baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than 0");
        }
        return new Position(positionId, positionTitle, description, baseSalary);
    }

    public static Position createPosition() {
        return new Position();
    }
}

