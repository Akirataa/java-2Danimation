package animation2D;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    Image moun;
    Image backgroundImage;
    Timer timer;

    int x = 0;
    int y = 0;
    int xVelocity = 2;
    int yVelocity = 1;

    int mounWidth = 100;
    int mounHeight = 100;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        moun = new ImageIcon("animation2D/img/moun.png").getImage();
        backgroundImage = new ImageIcon("animation2D/img/background.jpg").getImage();

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, this);

        g2D.drawImage(moun, x, y, mounWidth, mounHeight, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if (x >= PANEL_WIDTH - mounWidth || x < 0) {
            xVelocity *= -1;
        }
        
        if (y >= PANEL_HEIGHT - mounHeight || y < 0) {
            yVelocity *= -1;
        }

        x += xVelocity;
        y += yVelocity;

        repaint();
    }
}