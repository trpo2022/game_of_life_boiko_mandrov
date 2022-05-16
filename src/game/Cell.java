package game;

public class Cell {
    boolean alive;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set_alive(boolean alive) {
        this.alive = alive;
    }

    public boolean get_alive() {
        return alive;
    }

}
