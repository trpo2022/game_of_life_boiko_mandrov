package game;

import java.util.HashSet;
import java.util.Set;

public class Board {
    public static Set<Cell> now = new HashSet<>();
    int height;
    int width;
    public static int iteration;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        iteration = 0;
    }

    public void life() {
        Set<Cell> next = new HashSet<>();
        for (Cell cell : now) {
            int numberOfNeighbors = count_neb(cell);
            Cell next_cell = new Cell(cell.getX(), cell.getY());
            if (cell.get_alive() && (numberOfNeighbors == 2 || numberOfNeighbors == 3)) {
                next_cell.set_alive(true);
                next.add(next_cell);
            } else if (!cell.get_alive() && numberOfNeighbors == 3) {
                next_cell.set_alive(true);
                next.add(next_cell);
            } else {
                next_cell.set_alive(false);
                next.add(next_cell);
            }
        }
        if (UI.flag) {
            iteration++;
        }
        if (!find(next)) {
            replaceWithContentOf(next);
            next.clear();
        } else {
            UI.flag = false;
        }
    }

    public int count_neb(Cell cell) {
        int count = 0;
        int x = cell.getX();
        int y = cell.getY();
        if ((x > 0 || y > 0) || (x < width || y < height)) {
            if (now.stream().filter(z -> z.getX() == x + 1 && z.getY() == y + 1).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x + 1 && z.getY() == y).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x && z.getY() == y + 1).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x - 1 && z.getY() == y - 1).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x - 1 && z.getY() == y).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x && z.getY() == y - 1).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x + 1 && z.getY() == y - 1).anyMatch(Cell::get_alive)) {
                count++;
            }
            if (now.stream().filter(z -> z.getX() == x - 1 && z.getY() == y + 1).anyMatch(Cell::get_alive)) {
                count++;
            }
        }
        return count;
    }
}
