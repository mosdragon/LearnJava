import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This class wraps around a picture using our custom Pixel class.
 * Allows access to a pixel using Cartesian (x,y) coordinates.
 *
 * @author Aaron Friesen
 * @version 1.0
 */
public class Pic {
    private Pixel[][] pixels;
    private BufferedImage buff;
    private String imageName;

    /**
     * Constructor for Pic. Sets up the backing Pixel array.
     *
     * @param imageName The name of the image you want to load, as a String.
     * Includes file type.
     */
    public Pic(String imageName) {
        try {
            buff = ImageIO.read(new File(imageName));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Silly goose! That's not a valid file name.");
            System.exit(0);
        }
        this.imageName = imageName;
        pixels = new Pixel[buff.getHeight()][buff.getWidth()];
        ColorModel mod = buff.getColorModel();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                int p = buff.getRGB(col, row);
                int a = p >> 24 & 0xFF;
                int r = p >> 16 & 0xFF;
                int g = p >> 8 & 0xFF;
                int b = p & 0xFF;
                pixels[row][col] = new Pixel(r, g, b, a);
            }
        }
    }

    /**
     * Gets the width of the picture you set up in the constructor.
     *
     * @return The width of the picture.
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the picture you set up in the constructor.
     *
     * @return The height of the picture.
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets a Pixel object at an (row,col) point
     * (starting from the top-left at 0,0).
     * Note that any changes you make to the Pixel object are reflected
     * in the Pixel array!
     *
     * @param row The y coordinate of the pixel in question.
     * @param col The x coordinate of the pixel in question.
     * @return The pixel at x,y.
     */
    public Pixel getPixel(int row, int col) {
        return pixels[row][col];
    }

    /**
     * Returns a deep copy of the image. Useful when you want to
     * maintain a "clean" copy.
     *
     * @return The copy of the picture as a new Pic object.
     */
    public Pic deepCopy() {
        return new Pic(this.imageName);
    }

    /**
     * Shows the picture that corresponds to the Pixel array.
     * Don't worry too much about the
     * logic here - you'll learn about this soon enough.
     *
     */
    public void show() {
        JFrame frame = new JFrame("Your Picture!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                int convert = convert(pixels[row][col]);
                buff.setRGB(col, row, convert);
            }
        }

        frame.add(new JLabel(new ImageIcon(buff)));
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This is deep bitshifting magic. Also don't worry about this.
     *
     * @param p The pixel to convert back into int mode
     * @return The converted ARGB int.
     */
    private int convert(Pixel p) {
        return p.getAlpha() << 24 | p.getRed() << 16
             | p.getGreen() << 8 | p.getBlue();
    }
}
