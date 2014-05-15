//package hungergame;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JButton;
/**
 * GamePanel represents the Game.
 * @author Muhammad Sakhi
 * @version 1.9
 */
public class GamePanel extends JPanel {
    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;
    private ControlPanel cPanel;
    private Timer timer;
    private Rectangle bounds;
    private BufferedImage crossHairs, background;
    private Rectangle scope;
    private int scopeRange = 16;
    private Point lastMouse = new Point(400, 400);
    private static Nature nature = Nature.getInstance();
    /**
     * Contructor for the GamePanel.  Sets up the Panel, ControlPanel,
     * Timer, Mouse Adapter
     * @param cp Control Panel used to control the game
     */
    public GamePanel(ControlPanel cp) {
        cPanel = cp;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        background = getIcon("forest.png");
        //create a button called playPause.
        JButton playPause = new JButton("Play/Pause");
        playPause.setToolTipText("Start or pause the game.");
        /*add a TimerListener to playPause here.  It should play and
        pause the game */
        playPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                } else {
                    timer.start();
                }
            }
        });
        bounds = new Rectangle(0, 0, WIDTH, HEIGHT);
        cPanel.addButtonCenter(playPause);
        crossHairs = getIcon("crossRed74.png");
        MouseAdapter ma = new MouseTracker();
        setFocusable(true);
        addMouseListener(ma);
        addMouseMotionListener(ma);
        scope = new Rectangle(new Point(0, 0), new Dimension(
                crossHairs.getWidth(), crossHairs.getHeight()));
        timer = new Timer(200, new TimerListener());
        timer.start();
    }
    /**
     * Paints the game's panel's graphics.
     * @param g the graphics object to be painted
     */
    public void paintComponent(Graphics g) {
        try {
            repaint();
        } catch (NullPointerException ne) {
            System.out.println("Stopped from freezing");
        }
        g.drawImage(background, 0, 0, null);
        if (g != null) {
            nature.draw(g);
        }
        if (null != crossHairs) {
            Point middle = upperLeft(lastMouse, crossHairs.getWidth(),
                crossHairs.getWidth());
            int x = middle.x;
            int y = middle.y;
            g.drawImage(crossHairs, x, y, null);
        }
        cPanel.repaint();
    }
   /**
    * Shoots the animals in the given scope
    * Updates the hunger level and wanted level
    * @param scope the scope of the shot
    */
    private void shoot(Rectangle scope) {
        //You must complete this method
        int hunger = nature.shootFood(scope);
        cPanel.incHunger(hunger);
        int danger = nature.shootEndangered(scope);
        cPanel.incWanted(danger);
        cPanel.incHunger(danger);
    }
    /**
     * You are not required to know what exactly is going on in this method.
     * However, if you are curious, you should check out the API.
     * This inner class tracks the user's mouse and runs the apropriate code
     */
    private class MouseTracker extends MouseAdapter {
        @Override
        /**
         * Performed when the mouse is clicked
         * @param mc the MouseEvent
         */
        public void mouseClicked(MouseEvent mc) {
            if (GamePanel.this.timer.isRunning()) {
                Point mouseLoc = mc.getPoint();
                scope = new Rectangle(upperLeft(lastMouse, scopeRange,
                    scopeRange), new Dimension(scopeRange, scopeRange));
                shoot(scope);
            }
        }
        @Override
        /**
         * This is called when the mouse is moved
         * @param mc the MouseEvent
         */
        public void mouseMoved(MouseEvent mc) {
            //You must complete this method
            lastMouse.x = mc.getX();
            lastMouse.y = mc.getY();
            try {
                repaint();
            } catch (NullPointerException ne) {
                System.out.println("Stopped from freezing");
            }
        }
        @Override
        /**
         * This is called when the mouse exits the game panel
         * @param mc the MouseEvent
         */
        public void mouseExited(MouseEvent mExit) {
            try {
                repaint();
            } catch (NullPointerException ne) {
                System.out.println("Stopped from freezing");
            }
        }
    }
    /**
     * This is the timer. It updates hunger, moves animals, and
     * paints the crosshairs. Also checks if the player is dead
     * or arrested. It operates on every tick.
     */
    private class TimerListener implements ActionListener {
        /**
         * Overrides the actionPerformed from ActionListener
         * Updates hunger, moves the animals, paints the animals
         * and crosshairs, and checks if player is dead/arrested.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //You must complete this method
            cPanel.incHunger(-1);
            nature.motivate();
            repaint();
            if (cPanel.isArrested()) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You fool!"
                    + "\nYou've been arrested");
                System.exit(0);
            } else if (cPanel.isDead()) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You fool!"
                    + "\nYou died of hunger!");
                System.exit(0);
            }
        }
    }
    /**
     * Returns a BufferedImage from a source
     * @param fileName, the name of the file to retrieve an image of
     * @return a BufferedImage from the fileName, or null if it doesn't exist
     */
    protected static BufferedImage getIcon(String fileName) {
        File img = new File(fileName);
        try {
            return ImageIO.read(img);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading image: "
                    + fileName
                    + "\n" + e.getMessage());
        }
        return null;
    }
    /**
     * Returns the upper left Point given a center Point, width and height of
     * an image.
     * @param center the center (graphical) point
     * @param width the width of the image
     * @param height the height of the image
     * @return the new Point of the upper left corner
     */
    protected static Point upperLeft(Point centre, int width, int height) {
        return new Point(centre.x - width / 2, centre.y - height / 2);
    }
}