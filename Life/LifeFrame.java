package Life;

import javax.swing.*;
import java.awt.*;

//Фрейм для отображения циклов жизни
public class LifeFrame extends JFrame {

    public LifeFrame(int n, int k) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setBounds(screenWidth/3, screenHeight/3, k * 10 + 20, n * 10 + 70);
        setTitle("LIFE");
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}