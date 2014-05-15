import javax.swing.*;
import java.awt.event.*;

public class MyGui extends JFrame {
    protected final JButton button;
    public MyGui() {
        super("MyGui");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        button = new JButton("Click me!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, "Thanks!");
            }
        });
        add(button);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        MyGui gui = new MyGui();
    }
}