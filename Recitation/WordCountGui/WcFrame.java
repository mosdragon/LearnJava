import javax.swing.*;
import java.awt.*;

public class WcFrame extends JFrame {

    public WcFrame(Wc wc) {
        super("Word Count GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (String word : wc.getWordCounts().keySet()) {
            String listElement = word + ": " + wc.getWordCounts().get(word);
            lm.addElement(listElement);
        }
        JList jList = new JList(lm);
        add(new JScrollPane(jList), BorderLayout.CENTER);
        pack();
    }
}
