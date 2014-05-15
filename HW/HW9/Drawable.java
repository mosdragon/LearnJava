import java.awt.Graphics;
/**
 * This interface represents a pure type given to every drawable class
 * @author Muhammad Sakhi
 * @version 1.1
 */
public interface Drawable {
    /**
     * Something will be drawn
     * @param g, a Graphics object
     */
    void draw(Graphics g);
}
