

import game.Board;
import game.Cell;
import game.UI;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void life() {
        int[][] table = new int[3][3];
        table[0][0] = 1;
        table[0][1] = 1;
        table[1][0] = 1;
        table[1][1] = 1;
        UI b = new UI(table, 3, 3);
        Board a = b.getBoard();
        a.set_now(table);
        a.life();
        assertFalse(UI.flag);
    }

    @Test
    void find() {
        Set<Cell> next = new HashSet<>();
        int[][] table1 = new int[10][10];
        int[][] table2 = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                table1[i][j] = 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell f = new Cell(i, j);
                f.set_alive(false);
                next.add(f);
            }
        }
        Board a = new Board(10, 10);
        a.set_now(table1);
        assertFalse(a.find(next));
        a.set_now(table2);
        assertTrue(a.find(next));
    }

    @Test
    void count_neb() {
        int[][] table = new int[3][3];
        Cell find = new Cell(1, 1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = 1;
            }
        }
        Board a = new Board(3, 3);
        a.set_now(table);
        assertEquals(a.count_neb(find), 8);
        int[][] table2 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table2[i][j] = 0;
            }
        }
        table2[1][1] = 1;
        a.set_now(table2);
        assertEquals(a.count_neb(find), 0);
    }

    @Test
    void set_now() {
        int[][] table = new int[1][1];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                table[i][j] = 0;
            }
        }
        Board a = new Board(1, 1);
        a.set_now(table);
        assertEquals(a.get_now().size(), 1);
    }

    @Test
    void get_now() {
        int[][] table = new int[1][1];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                table[i][j] = 0;
            }
        }
        Board a = new Board(1, 1);
        a.set_now(table);
        assertEquals(a.get_now().size(), 1);
    }

}