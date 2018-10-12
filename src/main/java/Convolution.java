/**
 * Created by evilFrog5477 on 10/12/2018.
 */
public class Convolution {

    // Take 3x3 arrays
    public static int convolution(int[][] filter, int[][] image) {
        int magnitude = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                magnitude += filter[i][j] * image[i][j];
            }
        }
        return magnitude;
    }
}
