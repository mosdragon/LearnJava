import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
/**
 * The Animal class is the abstract base class for all animals
 * Animals have a Home where they are born and always come back to
 * Their center is their actual (graphical) location
 * their upperLeft is the point at the upperleft of the image.
 * They have a confort distance maxDist.  They don't like being farther
 * from home than that.
 * @author  Muhammad Sakhi
 * @version 1.1
 */
public abstract class Animal implements Drawable {
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
        maxDist = Nature.RAND.nextInt(351) + 150;
    }
    /**
     * Returns true if the Animal is moving
     * @return {@literal true} if the Animal is moving
     * {@literal false} otherwise
     */
    public boolean isMoving() {
        return isMoving;
    }
    /**
     * sets the movement of the animal.
     * @param isMoving, the literal boolean value to be set
     */
    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    /**
     * Teleports the Animal back to its home
     */
    public void teleport() {
        setLocation(home.getCenter());
    }
    /**
     * Updates the location of the upperLeft
     */
    private void updateLocation() {
        upperLeft = GamePanel.upperLeft(centre, width, height);
    }
    /**
     * Sets the new location of the center
     * @param p, the Point to be the new center
     */
    public void setLocation(Point p) {
        centre = new Point(p);
        updateLocation();
    }
    /**
     * Tranlates the location of the Animal
     * @param x, the x coordinate to translate by
     * @param y, the y coordinate to translate by
     */
    public void translate(int x, int y) {
        centre.translate(x, y);
        updateLocation();
    }
    /**
     * Gets the center location of the Animal
     * @return the Point where the center is
     */
    public Point getLoc() {
        return centre;
    }
    /**
     * Gets the upperLeft location of the Animal
     * @return the upperLeft Point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }
    /**
     * returns the width of the Animal's icon
     * @return width of the Animal's icon
     */
    public int getWidth() {
        return width;
    }
    /**
     * returns the height of the Animal's icon
     * @return height of the Animal's icon
     */
    public int getHeight() {
        return height;
    }
    /**
     * returns the Home of the Animal
     * @return Home of the Animal
     */
    public Home getHome() {
        return home;
    }
    /**
     * Sets the Home of the Animal
     * @param home, the Home to be set
     */
    public void setHome(Home home) {
        this.home = home;
    }
    /**
     * Determines whether the Animal is dead
     * @return {@literal true} if isDead is true, {@literal false} otherwise
     */
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
    /**
     * Determines whether the Animal is hidden.
     * @return {@literal true} if hidden, {@literal false} otherwise
     */
    public boolean isHidden() {
        return isHidden;
    }
    /**
     * Returns the maximum distance for this Animal
     * @return maxDist, the maximum distance
     */
    public double getMaxDist() {
        return maxDist;
    }
    /**
     * Returns the Direction for this Animal
     * @return dir, the Direction
     */
    public Direction getDir() {
        return dir;
    }
    /**
     * Sets the Direction for this Animal
     * @param dir, the Direction to be set
     */
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
            if (count > 5) {
                isDead = true;
                return true;
            }
        }
        return false;
    }
    /**
     * Determines if this Animal is equal to a specified Object
     * @param obj the Object being tested for equality
     * @return {@literal true} if this Animal is equal to the Object
     */
    @Override
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
    /**
     * Returns the hashCode for this Animal
     * @return the hashCode for this Animal
     */
    public int hashCode() {
        return this.centre.hashCode();
    }
    /**
     * Draws the icon at certain coordinates
     * @param g, the Graphics object to be drawn on
     */
    @Override
    public void draw(Graphics g) {
        Point pt = getUpperLeft();
        int x = pt.x;
        int y = pt.y;
        g.drawImage(icon, x, y, null);
    }
}
