package model;

public class Floor {
    private int width;
    private int height;

    public Floor(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void markPosition(int newX, int newY) {
        if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
            throw new IllegalArgumentException("Invalid coordinates.");
        }
        System.out.println("Position marked successfully.");
        System.out.println(newX + ", " + newY);
        System.out.println();
    }
}
