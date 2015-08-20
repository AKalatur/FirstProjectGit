package Life;

import javax.swing.*;
import java.awt.*;

class LifePanel extends JPanel {
    int[][] array;
    int count;
    String stateMes;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.drawString("Round" + count, 10, 10);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    g.setColor(Color.ORANGE);
                    g.drawOval(j * 10 + 5, i * 10 + 15, 10, 10);
                    g.fillOval(j * 10 + 5, i * 10 + 15, 10, 10);
                } else
                    g.setColor(Color.RED);
                g.drawOval(j * 10 + 5, i * 10 + 15, 10, 10);
                g.fillOval(j * 10 + 5, i * 10 + 15, 10, 10);
            }
        }
        g.setColor(Color.BLUE);
        if (stateMes.length() > 13) {
            g.drawString(stateMes.substring(0, 13), 10, array.length * 10 + 30);
            g.drawString(stateMes.substring(14, stateMes.length()), 10, array.length * 10 + 40);
        } else g.drawString(stateMes, 10, array.length * 10 + 30);
        repaint();
    }
}