import java.awt.image.BufferedImage;
import java.awt.Point;
/**
 * Represents a Home.  The home has a location.  Homes are drawable
 * @author Daniel Hay
 * @version 1.0
 */
public class Home {
    private Point upperLeft, center;
    private BufferedImage icon;
    /**
     * Constructs and instance of a Home.
     * @param imageName the file name of the icon
     * @param upperLeft the upper left point of the home
     */
    public Home(String imageName, Point upperLeft) {
        icon = GamePanel.getIcon(imageName);
        this.upperLeft = upperLeft;
        this.center = getNestCenter(upperLeft);
    }
    public Point getUpperLeft() {
        return upperLeft;
    }
    /**
     * Returns graphical location of the Home
     * @return the graphical location of the Home
     */
    public Point getCenter() {
        return center;
    }
    /**
     * calculates the center given the upper left corner
     * @param p the upper left point
     * @return the center location of the Home
     */
    private static Point getNestCenter(Point p) {
        Point newP = new Point(p);
        newP.translate(122, 115);
        return newP;
    }
}
