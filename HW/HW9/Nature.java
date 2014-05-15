import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import java.util.Random;
import java.awt.Graphics;
/**
 * This class is in charge of Animals and their nests.  It is also in charge of
 * moving and shooting Animals.
 * Nature is a singleton class, which means there is only ever one instance
 * @author Muhammad Osama Sakhi
 * @version 1.1
 */
public class Nature implements Drawable {
    private Vector<Animal> existingAnimals = new Vector<>(20);
    private Vector<Home> homes = new Vector<Home>();
    public static final Random RAND = new Random();
    private Class[] animals = {Panda.class, Boar.class, Shark.class,
        Turtle.class};
    private Class[] edibles = {Boar.class, Turtle.class};
    private Class[] endangered = {Panda.class, Shark.class};
    private Vector<Animal> chosenOnes = new Vector<Animal>();
    private static Nature nature = null;
    /**
     * This method returns the sole instance of Nature
     */
    public static Nature getInstance() {
        if (nature == null) {
            nature = new Nature();
        }
        return nature;
    }
    /**
     * Constructor for Nature sets up Home(s) and Animal(s)
     */
    private Nature() {
        homes.add(new Home("bush1.png", new Point(0, GamePanel.HEIGHT - 210)));
        homes.add(new Home("bush2.png", new Point(GamePanel.WIDTH - 256,
            GamePanel.HEIGHT - 210)));
        for (int i = 0; i < 6; ++i) {
            addAnimal();
        }
    }
    /**
     * Draws the corresponding animals and homes onto the Graphics g.
     * @param g, the Graphics object to be painted.
     */
    @Override
    public void draw(Graphics g) {
        for (Animal a : existingAnimals) {
            a.draw(g);
        }
        for (Home h : homes) {
            h.draw(g);
        }
    }
    /**
     * This method returns a random element in a generic array.
     * @param arr generic array
     * @return random element of generic array
     */
    private static <Q> Q randomSelection(Q[] arr) {
        int len = arr.length;
        return arr[RAND.nextInt(len)];
    }
    /**
     * This method returns a random element in a generic Vector
     * @param arrL generic Vector
     * @return random element in generic Vector
     */
    private static <E> E randomSelection(Vector<E> arrL) {
        int len = arrL.size();
        return arrL.get(RAND.nextInt(len));
    }
    /**
     * This method creates and adds a random animal (from given classes)
     * associated with a random nest.
     */
    public void addAnimal() {
        existingAnimals.add(createAnimal(randomSelection(homes)));
    }
    /**
     * This method shoots all moving Edible Animals within the scope.
     * @param scope the scope of the shot.
     * @return the food points associated with all killed Edible Animals.
     */
    public int shootFood(Rectangle scope) {
        int points = 0;
        for (int i = 0; i < chosenOnes.size(); ++i) {
            Animal selected = chosenOnes.get(i);
            if (selected != null) {
                if (selected instanceof Edible) {
                    if (selected.isHit(scope)) {
                        points += ((Edible) selected).getFoodPoints();
                        existingAnimals.remove(selected);
                        chosenOnes.remove(selected);
                        addAnimal();
                    }
                }
            }
        }
        return points;
    }
    /**
     * Creates a specific Animal.
     * This uses reflection.
     * @param cl the Specific concrete class of an Animal.
     * @param home the Home that the Animal considers home.
     * @return the created Animal
     */
    public Animal createAnimal(Class cl, Home home) {
        try {
            return (Animal) cl.getDeclaredConstructor(Home.class)
                    .newInstance(home);
        } catch (NoSuchMethodException m) {
            System.out.println(m.getMessage());
            m.printStackTrace();
            return null;
        } catch (InstantiationException i) {
            System.out.println(i.getMessage());
            i.printStackTrace();
            return null;
        } catch (IllegalAccessException i) {
            System.out.println(i.getMessage());
            i.printStackTrace();
            return null;
        } catch (InvocationTargetException i) {
            System.out.println(i.getMessage());
            i.printStackTrace();
            return null;
        }
    }
    /**
     * Creates a random Animal from given concrete subclasses.
     * @param home the Home that the Animal considers home.
     * @return the created Animal
     */
    public Animal createAnimal(Home home) {
        return createAnimal(randomSelection(animals), home);
    }
    /**
     * Creates a random Edible Animal
     * @param home the Home that the Animal considers home.
     * @return the created Edible Animal
     */
    public Animal createEdible(Home home) {
        return createAnimal(randomSelection(edibles), home);
    }
    /**
     * Creates a random Endangered Animal
     * @param home the Home that the Animal considers home.
     * @return the created Endangered Animal
     */
    public Animal createEndangered(Home home) {
        return createAnimal(randomSelection(endangered), home);
    }
    /**
     * This method shoots all moving Endangered Animals within the scope.
     * @param scope the scope of the shot.
     * @return cumulative wanted level associated with killed Endangered Animals
     */
    public int shootEndangered(Rectangle scope) {
        int num = 0;
        Animal selected;
        for (int i = 0; i < chosenOnes.size(); ++i) {
            if (chosenOnes.get(i) != null) {
                selected = chosenOnes.get(i);
                if (selected instanceof EndangeredSpecies) {
                    if (selected.isHit(scope)) {
                        num += ((EndangeredSpecies) selected).getWantedLevel();
                        existingAnimals.remove(selected);
                        chosenOnes.remove(selected);
                        addAnimal();
                    }
                }
            }
        }
        return num;
    }
    /**
     * This method is in charge of selecting animals from the Homes and
     * letting them take a walk.  If the animal gets too far from home
     * than its confortable, it guides it back home.
     */
    public void motivate() {
        if (chosenOnes.size() < 3) {
            int most = RAND.nextInt(2) + 2;
            for (int i = 0; i < most; ++i) {
                Animal selected = randomSelection(existingAnimals);
                selected.setDir(Direction.OUT);
                selected.show();
                selected.teleport();
                selected.setMoving(true);
                chosenOnes.add(selected);
            }
        }
        int y;
        int x;
        for (int i = 0; i < chosenOnes.size(); ++i) {
            Animal selected = chosenOnes.get(i);
            if (selected == null) {
                System.exit(1);
            }
            y = RAND.nextInt(20);
            x = RAND.nextInt(60) - 30;
            x = ((selected.getUpperLeft().x + x <= 0)
                            || (selected.getLoc().x + x + selected.getWidth()
                            >= GamePanel.WIDTH)) ? -x : x;
            if (selected.getDir().equals(Direction.OUT)) {
                if (selected.getHome().getCenter().distance(selected.getLoc())
                        >= selected.getMaxDist()) {
                    selected.setDir(Direction.IN);
                } else {
                    selected.translate(x, -y);
                }
            } else if (selected.getDir().equals(Direction.IN)) {
                if (selected.getHome().getCenter().distance(selected.getLoc())
                        <= 60) {
                    selected.hide();
                    chosenOnes.remove(selected);
                    ++i;
                } else {
                    x = (selected.getLoc().distance(new Point(
                            selected.getHome().getCenter().x + x,
                                    selected.getHome().getCenter().y))
                            > selected.getLoc().distance(new Point(
                                selected.getHome().getCenter().x - x,
                                    selected.getHome().getCenter().y)))
                            ? x : -x;
                    if (selected.getLoc().y + y + selected.getHeight() / 2
                            < GamePanel.HEIGHT) {
                        selected.translate(x, y);
                    }
                }
            }
        }
    }
}
