public class ImageProcessor {

    private Pic original;
    private Pic working;
    private int red;
    private int green;
    private int blue;
    private int avg;
    private int rows;
    private int cols;
    private final int colorMAX = 255;
    private final int colorMIN = 0;
    public ImageProcessor(String filename) {
        original = new Pic(filename);
        rows = original.getHeight();
        cols = original.getWidth();
    }
    public Pic maximize() {
        working = original.deepCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel current = working.getPixel(r, c);
                red = current.getRed();
                green = current.getGreen();
                blue = current.getBlue();
                if (red > green && red > blue) {
                    current.setGreen(colorMIN);
                    current.setBlue(colorMIN);
                } else if (green > red && green > blue) {
                    current.setRed(colorMIN);
                    current.setBlue(colorMIN);
                } else if (blue > red && blue > green) {
                    current.setRed(colorMIN);
                    current.setGreen(colorMIN);
                } else if (red == green && red != blue) {
                    current.setBlue(colorMIN);
                } else if (blue == green && green != red) {
                    current.setRed(colorMIN);
                } else if (red == blue && blue != green) {
                    current.setGreen(colorMIN);
                }
            }
        }
        return working;
    }
    public Pic greyscale() {
        working = original.deepCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel current = working.getPixel(r, c);
                red = current.getRed();
                green = current.getGreen();
                blue = current.getBlue();
                avg = (red + green + blue) / 3;
                current.setRed(avg);
                current.setGreen(avg);
                current.setBlue(avg);
            }
        }
        return working;
    }
    public Pic invert() {
        working = original.deepCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel current = working.getPixel(r, c);
                red = colorMAX - current.getRed();
                green = colorMAX - current.getGreen();
                blue = colorMAX - current.getBlue();
                current.setRed(red);
                current.setGreen(green);
                current.setBlue(blue);
            }
        }
        return working;
    }
    public Pic noRed() {
        working = original.deepCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel current = working.getPixel(r, c);
                current.setRed(colorMIN);
            }
        }
        return working;
    }
    public Pic noGreen() {
        working = original.deepCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel current = working.getPixel(r, c);
                current.setGreen(colorMIN);
            }
        }
        return working;
    }
    public Pic noBlue() {
        working = original.deepCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel current = working.getPixel(r, c);
                current.setBlue(colorMIN);
            }
        }
        return working;
    }
    public Pic overlay(Pic other) {
        working = original.deepCopy();
        int otherRed;
        int otherGreen;
        int otherBlue;
        int avgR;
        int avgG;
        int avgB;
        int otherRows = other.getHeight();
        int otherCols = other.getWidth();
        int minR = Math.min(rows, otherRows);
        int minC = Math.min(cols, otherCols);
        for (int r = 0; r < minR; r++) {
            for (int c = 0; c < minC; c++) {
                Pixel current = working.getPixel(r, c);
                Pixel outsider = other.getPixel(r, c);
                // The original pic's RGB values
                red = current.getRed();
                green = current.getGreen();
                blue = current.getBlue();
                // These are the other pics RGB values
                otherRed = outsider.getRed();
                otherGreen = outsider.getGreen();
                otherBlue = outsider.getBlue();
                // Average the original and outsider RGB vals and set them
                avgR = (red + otherRed) / 2;
                avgG = (green + otherGreen) / 2;
                avgB = (blue + otherBlue) / 2;
                current.setRed(avgR);
                current.setGreen(avgG);
                current.setBlue(avgB);
            }
        }
        return working;
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            ImageProcessor img = new ImageProcessor(args[0]);
            img.greyscale().show();
            img.invert().show();
            img.noRed().show();
            img.noGreen().show();
            img.noBlue().show();
            img.maximize().show();
            if (args.length > 1) {
                img.overlay(new Pic(args[1])).show();
            }
        }
    }
}