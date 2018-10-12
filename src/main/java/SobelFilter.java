/**
 * Created by evilFrog5477 on 10/12/2018.
 */
public class SobelFilter implements Filter {

    private SimpleImage image;
    private int[][] xkernal = {{-1, 0, 1},
                               {-2, 0, 2},
                               {-1, 0, 1}};

    private int[][] ykernal = {{-1, -2, -1},
                               {0, 0, 0},
                               {1, 2, 1}};

    public SobelFilter(SimpleImage image) {
        this.image = image;
    }

    public void applyFilter() {
        int[][] rgbMatrix = this.image.getPixelValuesAs2DArray();
        int[][] subMatrix = new int[3][3];
        for (int i = 1; i < this.image.getWidth() - 2; i++) {
            for (int j = 1; j < this.image.getHeight() - 2; j++) {
                subMatrix[0][0] = rgbMatrix[i - 1][j-1];
                subMatrix[0][1] = rgbMatrix[i][j - 1];
                subMatrix[0][2] = rgbMatrix[i + 1][j - 1];
                subMatrix[1][0] = rgbMatrix[i - 1][j];
                subMatrix[1][1] = rgbMatrix[i][j];
                subMatrix[1][2] = rgbMatrix[i + 1][j];
                subMatrix[2][0] = rgbMatrix[i - 1][j + 1];
                subMatrix[2][1] = rgbMatrix[i][j + 1];
                subMatrix[2][2] = rgbMatrix[i + 1][j + 1];

                int xmag = Convolution.convolution(xkernal, subMatrix);
                int ymag = Convolution.convolution(ykernal, subMatrix);
                int mag = (int) Math.sqrt(xmag * xmag + ymag * ymag);
                image.setPixelValue(mag << 16 | mag << 8 | mag, i, j);
//                if (mag > 20000) {
//                    image.setPixelValue(255, 0, 0, 0, j, i);
//                } else {
//                    image.setPixelValue(255, 255, 255, 255, j, i);
//                }

            }
        }
    }
}
