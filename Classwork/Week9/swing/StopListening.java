import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StopListening implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        try {itsATrap();
        } catch (Exception done) {
            itsATrap();
        }
    }

    public void itsATrap() throws Exception {
        String msg = "You shouldn't have done that!";
        throw new Exception(msg);
    }
}