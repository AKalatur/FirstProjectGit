package Life;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Фрейм для ввода N или K
public class InputFrame extends JFrame {

    public InputFrame() {
        setBounds(350, 350, 250, 150);
        setResizable(false);

        InputPanel iPanel = new InputPanel();
        add(iPanel);
    }
}

// Панель с текстовым полем и кнопкой
class InputPanel extends  JPanel {
    static String buttonPressed;

    public InputPanel() {
        setLayout(new GridLayout(2, 1));

        final JTextField tField = new JTextField();
        add(tField);

        //При нажатии кнопки проверяется какой кнопкой было вызвано окно и проверяется условие на N и K
        JButton okButton = new JButton("OK");
        add(okButton);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (InputPanel.buttonPressed.equals("N")) {
                        if (Integer.parseInt(tField.getText()) < 10) {
                            JOptionPane.showMessageDialog(null, "CONDITIONS: Integer > 9", "WARNING", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            Life.n = Integer.parseInt(tField.getText());
                            StartPanel.iFrame.setVisible(false);
                            tField.setText("");
                        }
                    }
                    if (InputPanel.buttonPressed.equals("K")) {
                        if (Integer.parseInt(tField.getText()) < 10) {
                            JOptionPane.showMessageDialog(null, "CONDITIONS: Integer > 9", "WARNING", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            Life.k = Integer.parseInt(tField.getText());
                            StartPanel.iFrame.setVisible(false);
                            tField.setText("");
                        }
                    }
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "CONDITIONS: Integer > 9", "WARNING", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }


}
