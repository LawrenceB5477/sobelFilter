import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by evilFrog5477 on 10/12/2018.
 */
public class GrayScale implements Filter {
    private SimpleImage img;

    public GrayScale(SimpleImage sb) {
        this.img = sb;
    }


    public void applyFilter() {
        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        int pixel = 0;

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                pixel = img.getPixelValue(x, y);
                a = (pixel >> 24) & 0xFF;
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel >> 0) & 0xFF;

                int grayScale = (a + r + g + b) / 4;
                int gray = (grayScale << 24) + (grayScale << 16) + (grayScale << 8) + grayScale;
                img.setPixelValue(gray, x, y);
                //Each pixel is 32 bits, from bits 0-31
                //alpha 31-24
                //r 16-23
                //g 8-15
                //b 0-7


            }
        }
    }
}
