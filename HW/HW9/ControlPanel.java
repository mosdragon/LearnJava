import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
/**
 * Represents a panel of controls with buttons and status items
 * that control and show status of the game.
 * @author Muhammad Sakhi
 * @version 1.1
 */
public class ControlPanel extends JPanel {
    private JProgressBar hungerBar;
    private final int hungerMax = 200;
    private int hunger = hungerMax;
    private JProgressBar wantedBar;
    private int wantedLevel = 0;
    private final int arrestLevel = 10;
    /**
     * Constructor for ControlPanel. Creates an instance of ControlPanel.
     */
    public ControlPanel() {
        //specify the size
        this.setPreferredSize(new Dimension(75, 75));
        //specify the layout
        this.setLayout(new BorderLayout());
        hungerBar = new JProgressBar(0, hungerMax);
        wantedBar = new JProgressBar(0, arrestLevel);
        wantedBar.setValue(0);
        wantedBar.setStringPainted(true);
        wantedBar.setString("Wanted");
        hungerBar.setValue(hungerMax);
        hungerBar.setStringPainted(true);
        hungerBar.setString("Hunger");
        //add the ProgressBars to the panel
        this.add(hungerBar, BorderLayout.WEST);
        this.add(wantedBar, BorderLayout.EAST);
        setVisible(true);
    }
    /**
     * Adds a JButton in the Center of the Panel
     * @param jb the button to be added
     */
    public void addButtonCenter(JButton jb) {
        // add the button in the middle of the panel
        add(jb, BorderLayout.CENTER);
    }
    /**
     * Returns true if the player has died of starvation.
     * @return {@literal true} if the player is dead. {@literal false}
     * otherwise.
     */
    public boolean isDead() {
        return hunger <= 0;
    }
    /**
     * Increments the wantel level of the player
     * @param inc amount to increase the wanted level
     */
    public void incWanted(int inc) {
        wantedLevel += inc;
        if (wantedLevel > arrestLevel) {
            wantedLevel = arrestLevel;
        }
        wantedBar.setValue(wantedLevel);
    }
    /**
     * Returns true if the player has been arrested
     * @return {@literal true} if the player has been arrested. {@literal false}
     * if the player is not arrested.
     */
    public boolean isArrested() {
        return wantedLevel >= arrestLevel;
    }
    /**
     * Increments the hunger level of the player
     * @param n the amount of hunger to increase
     */
    public void incHunger(int n) {
        hunger += n;
        if (hunger > hungerMax) {
            hunger = hungerMax;
        } else if (hunger < 0) {
            hunger = 0;
        }
        hungerBar.setValue(hungerMax - hunger);
    }
}