import javax.swing.*;
import java.io.*;

public class WcGui {

    public static void main(String[] args) {
        File pwd = new File(System.getProperty("user.dir"));
        JFileChooser fileChooser = new JFileChooser(pwd);
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
            File file = fileChooser.getSelectedFile();
            try {
                Wc wc = new Wc(file);
                WcFrame wcFrame = new WcFrame(wc);
                wcFrame.setVisible(true);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}

