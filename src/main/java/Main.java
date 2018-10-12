import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by evilFrog5477 on 10/12/2018.
 */
public class Main {

    public static void main(String[] args) {
        FilteredImage image = null;
        try {
            image = new FilteredImage("C:\\Users\\Lbadv\\Desktop\\edgedetection\\src\\main\\resources\\image0.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }


        GrayScale gs = new GrayScale(image);
        image.addFilter(gs);
        SobelFilter sb = new SobelFilter(image);
        image.addFilter(sb);
        image.applyAllFilters();

        image.displayImage();
    }

}
