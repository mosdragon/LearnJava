import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 * The Animal class is the abstract base class for all animals
 * Animals have a Home where they are born and always come back to
 * Their center is their actual (graphical) location
 * their upperLeft is the point at the upperleft of the image.
 * They have a confort distance maxDist.  They don't like being farther
 * from home than that.
 * @author Daniel Hay
 * @version 1.0
 */
public abstract class Animal {
    private BufferedImage icon;
    private Point centre;
    private Point upperLeft;
    private int width, height;
    private Direction dir = Direction.OUT;
    private final double maxDist;
    private Home home;
    private boolean isDead = false;
    private boolean isHidden = true, isMoving = false;
    /**
     * Constructs a new Animal object
     * @param imageName the filename of the Animal's icon
     * @param home the Animal's birthplace and residence
     */
    public Animal(String imageName, Home home) {
        this.icon = GamePanel.getIcon(imageName);
        this.home = home;
        this.centre = new Point(home.getCenter());
        this.width = icon.getWidth();
        this.height = icon.getHeight();
        this.upperLeft = GamePanel.upperLeft(centre, width, height);
    }
    /**
     * Returns true if the Animal is moving
     * @return {@literal true} if the Animal is moving
     */
    public boolean isMoving() {
        return isMoving;
    }
    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    /**
     * Teleports the Animal back to its home
     */
    public void teleport() {
        setLocation(home.getCenter());
    }
    private void updateLocation() {
        upperLeft = GamePanel.upperLeft(centre, width, height);
    }
    public void setLocation(Point p) {
        centre = new Point(p);
        updateLocation();
    }
    /**
     * Tranlates the location of the Animal
     */
    public void translate(int x, int y) {
        centre.translate(x, y);
        updateLocation();
    }
    public Point getLoc() {
        return centre;
    }
    public Point getUpperLeft() {
        return upperLeft;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Home getHome() {
        return home;
    }
    public void setHome(Home home) {
        this.home = home;
    }
    public boolean isDead() {
        return isDead;
    }
    /**
     * Hides the Animal
     */
    public void hide() {
        isHidden = true;
    }
    /**
     * Shows the Animal (it stops hiding)
     */
    public void show() {
        isHidden = false;
    }
    public boolean isHidden() {
        return isHidden;
    }
    public double getMaxDist() {
        return maxDist;
    }
    public Direction getDir() {
        return dir;
    }
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    /**
     * Determines whether this Animal is hit by a shot
     * If this Animal is indeed hit, the Animal dies
     * @param scope the scope of the shot
     * @return {@literal true} if the Animal is hit
     */
    public boolean isHit(Rectangle scope) {
        Rectangle body = new Rectangle(upperLeft, new Dimension(width, height));
        if (!body.intersects(scope)) {
            return false;
        }
        Rectangle rect = scope.intersection(body);
        rect.translate(-upperLeft.x, -upperLeft.y);
        int[] img = icon.getRGB(rect.getLocation().x, rect.getLocation().y,
                                (int) rect.getWidth(), (int) rect.getHeight(),
                                null, 0, width);
        int count = 0;
        for (int i : img) {
            if (i != 0) {
                ++count;
            }
            if (count > 3) {
                isDead = true;
                return true;
            }
        }
        return false;
    }
    @Override
    /**
     * Determines if this Animal is equal to a specified Object
     * @param obj the Object being tested for equality
     * @return {@literal true} if this Animal is equal to the Object
     */
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Animal)) {
            return false;
        }
        return (this.centre.equals(((Animal) obj).centre)
                && this.getClass().equals(obj.getClass()));
    }

    public int hashCode() {
        return this.centre.hashCode();
    }
}
