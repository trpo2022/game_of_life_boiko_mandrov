
import game.Board;
import game.UI;
import org.junit.jupiter.api.Test;


import java.awt.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


class UITest {

    @Test
    void getBoard() {
        int[][] f = new int[3][3];
        UI a = new UI(f, 3, 3);
        Board now = a.getBoard();
        assertEquals(now.getHeight(), 3);
    }

    @Test
    void start() {
        int[][] f = new int[3][3];
        UI a = new UI(f, 3, 3);
        Component[] components = a.getComponents();
        int count = 0;
        for (Component ab : components) {
            count++;

        }
        assertEquals(count, 3);
    }
}