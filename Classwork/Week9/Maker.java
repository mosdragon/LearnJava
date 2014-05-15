import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Maker {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Hello, Swing!");
        mainFrame.setSize(640, 480);
        ImageIcon icon= new ImageIcon("pic.jpg");
            //ImageIcon image = new ImageIcon(ImageIcon.getResource("pic.jpg"));
        JLabel label = new JLabel(icon);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setVisible(true); 
        /*try {
            Thread.sleep(3000);
        } catch (Throwable t) {
            mainFrame.add(label);
           
        }*/
    }
}