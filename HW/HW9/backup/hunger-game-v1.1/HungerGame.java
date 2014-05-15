import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 * Driver class for the game
 * @author Daniel Hay
 * @version 1.0
 */
public class HungerGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hunger Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.SOUTH);
        frame.add(new GamePanel(control));
        frame.pack();
        frame.setVisible(true);
    }
}
