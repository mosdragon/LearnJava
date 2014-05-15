import java.io.*;
import java.awt.*;
import javax.swing.JFrame;
public class ExTester {
    
    public static void exMsg(String msg) throws Exception {
        throw new Exception(msg);
    }
    public static void illMsg(String msg) throws Exception {
        throw new FileNotFoundException(msg);
    }
    public static void main(String[] args) {
        //ExTester.exMsg("Doozie");
        try {
            exMsg("Doozie");
            System.out.print("yeehaw"); //Won't show up b/c of Exception
        } catch (Exception e) {
            System.out.println("I'm aliiiiive. The message was " + e.getMessage());
            e.printStackTrace();
        }
        Frame myFrame = new Frame("my Frame");  //create window Frame 
        Button myButton = new Button("my Button"); //create myButton 
        myFrame.add("Center",myButton);  //put myButton in myFrame 
        myFrame.setVisible(true); //button appears in window on screen 
        //setVisible() creates peer objects for myFrame & myButton 
        //ComponentPeer buttonPeer = myButton.getPeer(); //now works

        /*Frame screen = new Frame("Example 1"); 
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(400,500); 
        screen.setVisible(true);
        screen.setBackground(Color.red); 
        screen.setLayout(new FlowLayout()); 
        screen.add("Center", myButton);*/
    }
}