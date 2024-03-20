package repository;

import model.Floor;

public class FloorRepository {
    private Floor floor;

    public void saveFloor(Floor floor) {
        this.floor = floor;
        System.out.println("Floor grid data saved successfully.");
    }

    public Floor getFloor() {
        if (floor == null) {
            System.out.println("No floor grid data found.");
            return null;
        }
        return floor;
    }
}
