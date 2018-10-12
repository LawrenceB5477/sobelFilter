import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by evilFrog5477 on 10/12/2018.
 */


public class SimpleImage {
    private BufferedImage bi;
    private int width;
    private int height;

    public SimpleImage(BufferedImage bi) {
        this.bi = bi;
        this.width = this.bi.getWidth();
        this.height = this.bi.getHeight();
    }

    public SimpleImage(String path) throws IOException {
        this.bi = ImageIO.read(new File(path));
        this.width = this.bi.getWidth();
        this.height = this.bi.getHeight();
    }

    public BufferedImage getBufferedImage() {
        return bi;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setPixelValue(int a, int r, int g, int b, int x, int y) {
        int p = 0;
        p = (a<<24) | (r<<16) | (g<<8) | b;
        this.bi.setRGB(x, y, p);

    }

    public void setPixelValue(int value, int x, int y) {
        this.bi.setRGB(x, y, value);

    }

    public int getPixelValue(int x, int y) {
        int pixel = this.bi.getRGB(x, y);
        return pixel;
    }

    //Returns an array with argb values as integers
    public int[] getPixelValueArray(int x, int y) {
        int pixel = getPixelValue(x, y);
        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;

        //Each pixel is 32 bits, from bits 0-31
        //alpha 31-24
        //r 16-23
        //g 8-15
        //b 0-7

        a = (pixel >> 24) & 0xFF;
        r = (pixel >> 16) & 0xFF;
        g = (pixel >> 8) & 0xFF;
        b = (pixel >> 0) & 0xFF;

        return new int[] {a, r, g, b};
    }

    //Returns red values
    public int[][] getPixelValuesAs2DArray() {
        int[][] pixels = new int[this.width][this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                pixels[i][j] = new Color(this.bi.getRGB(i, j)).getRed();
            }
        }
        return pixels;
    }

    public void displayImage() {
        //Displaying the image, convenience
        JLabel picLabel = new JLabel(new ImageIcon(this.bi));
        JPanel jp = new JPanel();
        jp.add(picLabel);

        JFrame f = new JFrame();
        f.setSize(this.width, this.height);
        f.add(jp);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);

    }
}
