package game;

import javax.swing.*;
import java.awt.*;


public class UI extends JPanel {
    int[][] table;
    int height;
    int width;
    Board wow;
    private static Timer timer;
    public static boolean flag;

    public UI(int[][] table, int width, int height) {
        this.table = table;
        this.height = height;
        this.width = width;
        flag = true;
        wow = new Board(width, height);
        start();
    }

    public Board getBoard() {
        return wow;
    }

    public void start() {
        JLabel l = new JLabel("Let's play:");
        l.setBounds(160, 30, 100, 30);
        JButton a = new JButton("start");
        a.setBounds(130, 70, 150, 40);
        a.addActionListener(e -> {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    table[i][j] = (int) (Math.random() * 2);
                }
            }
            wow.set_now(table);
            timer = new Timer(500, x -> {
                this.repaint();
                timer.restart();
                wow.life();
            });
            timer.start();
        });
        JButton c = new JButton("exit");
        c.setBounds(130, 150, 150, 40);
        c.addActionListener(e -> System.exit(0));
        add(l);
        add(a);
        add(c);
    }
}
