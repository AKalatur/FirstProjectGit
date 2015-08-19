package Life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Первоначальный фрейм с тремя кнопками(ввод n, ввод k, START) + окно для ввода n,k
public class StartFrame extends JFrame {

    public StartFrame() {

        setBounds(300, 300, 250, 150);
        setTitle("START WINDOW");
        setResizable(false);

        StartPanel sPanel = new StartPanel();
        add(sPanel);
    }
}

//панель с копками
class StartPanel extends JPanel {
    static InputFrame iFrame = new InputFrame();

    public StartPanel() {
        setLayout(new GridLayout(3,1));

        //при нажатии кнопки открывается окно для ввода N
        JButton nButton = new JButton("Input N");
        add(nButton);
        nButton.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            iFrame.setTitle("INPUT N");;
                                            iFrame.setVisible(true);
                                            InputPanel.buttonPressed = "N";
                                        }
        });

        //при нажатии кнопки открывается окно для ввода K
        JButton kButton = new JButton("Input K");
        add(kButton);
        kButton.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            iFrame.setTitle("INPUT K");
                                            iFrame.setVisible(true);
                                            InputPanel.buttonPressed = "K";
                                        }
        });

        //при нажатии кнопки стартует цижненный цикл
        JButton startButton = new JButton("START");
        add(startButton);
        startButton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                if (Life.n == 0 || Life.k ==0) {
                                                    JOptionPane.showMessageDialog(null, "Input N and K first", "WARNING", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                else {
                                                    Thread t = new Thread(new Life());
                                                    t.start();
                                                }
                                            }
        });
    }
}
