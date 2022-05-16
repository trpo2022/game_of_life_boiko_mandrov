package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final int height = 10;
        final int width = 10;
        int[][] table = new int[width][height];
        UI ui = new UI(table, width, height);
        JFrame frame = new JFrame();
        frame.add(ui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}