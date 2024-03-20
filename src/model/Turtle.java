package model;

public class Turtle {
    private int[] position; // [x, y] coordinates
    private int direction; // 0 - North, 90 - East, 180 - South, 270 - West

    public Turtle(int x, int y, int direction) {
        this.position = new int[]{x, y};
        this.direction = direction;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
