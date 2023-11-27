package finalexam.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SortingDisplay extends JInternalFrame{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DELAY = 5;

    private int[] values;
    private BufferedImage offScreenImage;

    public SortingDisplay(int[] values) {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.values = values;
    }

    private void drawArray(Graphics g) {
        int BAR_WIDTH = WIDTH / values.length;
        for (int i = 0; i < values.length; i++) {
            int x = i * BAR_WIDTH;
            int height = values[i];
            g.setColor(Color.BLUE);
            g.fillRect(x, HEIGHT - height, BAR_WIDTH, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, HEIGHT - height, BAR_WIDTH, height);
        }
    }

    public void sleep() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        Graphics offScreenGraphics = offScreenImage.getGraphics();
        offScreenGraphics.setColor(Color.WHITE);
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        drawArray(offScreenGraphics);

        g.drawImage(offScreenImage, 0, 0, this);
    }
}