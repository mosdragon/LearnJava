import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 

public class RobotExp { 

    public static void main(String[] args) { 

        try { 

            Robot robot = new Robot(); 
            // Creates the delay of 5 sec so that you can open notepad before 
            // Robot start writting 
            robot.delay(5000);
           /* for (int i = 0; i < 3; i ++) {
                robot.keyPress(KeyEvent.VK_H); 
                robot.keyPress(KeyEvent.VK_I); 
                robot.keyPress(KeyEvent.VK_SPACE); 
                robot.keyPress(KeyEvent.VK_B); 
                robot.keyPress(KeyEvent.VK_U); 
                robot.keyPress(KeyEvent.VK_D);
                robot.keyRelease(KeyEvent.VK_D); 
                robot.keyPress(KeyEvent.VK_D);
                robot.keyPress(KeyEvent.VK_Y); 
                robot.keyPress(KeyEvent.VK_BACK_SLASH);
                robot.keyPress(KeyEvent.VK_N);
                robot.mouseMove(100,-200);
                robot.mouseMove(100,200);
                robot.mouseMove(-100,200);
                robot.mouseMove(-100,-200);
            }*/
            robot.setAutoDelay(1000);
            robot.mouseMove(500, 450);
            robot.mouseMove(500, 350);
            robot.mouseMove(600, 350);
            robot.mouseMove(600, 450);
            

        } catch (AWTException e) { 
            e.printStackTrace(); 
        } 
        System.out.println("Get ready: hi buddy\nhi buddy\nhi buddy\nhi buddy\nhi buddy\nhi buddy\n");
    } 
}