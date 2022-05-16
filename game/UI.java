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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);
        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        int zoom = 20;
        if (UI.flag) {
            g2d.drawString("Iteration :" + Board.iteration, 130, 100);
            for (Cell liveCell : wow.get_now()) {
                int x = (liveCell.x * zoom) % w + w / 2;
                int y = (liveCell.y * zoom) % h + 50;
                if (liveCell.get_alive()) {
                    g2d.drawRect(x, y, zoom, zoom);
                    g2d.fillRect(x, y, zoom, zoom);
                } else {
                    g2d.clearRect(x, y, zoom, zoom);
                }

            }
        } else {
            g2d.drawString("FINISH!!!", 130, 100);
        }
    }
}
