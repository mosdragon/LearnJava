import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 * Driver class for the game
 * @author Muhammad Sakhi
 * @version 1.5
 */
public class HungerGame {
    /**
     * Main method, executed through Terminal
     * @param args, a String[]
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hunger Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.SOUTH);
        frame.add(new GamePanel(control), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
