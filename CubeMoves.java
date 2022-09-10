package rubikscubesolver;

public class CubeMoves {
    private static char[][][] swapCW(char[][][] cube, int i1, int j1, int k1, int i2, int j2, int k2) {
        char temp = cube[i1][j1][k1];
        cube[i1][j1][k1] = cube[i2][j2][k2];
        cube[i2][j2][k2] = temp;
        return cube;
    }

    private static char[][][] swapCCW(char[][][] cube, int i2, int j2, int k2, int i1, int j1, int k1) {
        char temp = cube[i1][j1][k1];
        cube[i1][j1][k1] = cube[i2][j2][k2];
        cube[i2][j2][k2] = temp;
        return cube;
    }

    public static char[][][] WCW(char[][][] cube) {
        cube = swapCW(cube, 0, 0, 0, 0, 0, 2);
        cube = swapCW(cube, 0, 0, 1, 0, 1, 2);
        cube = swapCW(cube, 0, 0, 2, 0, 2, 2);
        cube = swapCW(cube, 0, 1, 0, 0, 0, 1);
        cube = swapCW(cube, 0, 1, 1, 0, 1, 1);
        cube = swapCW(cube, 0, 1, 2, 0, 2, 1);
        cube = swapCW(cube, 0, 2, 0, 0, 0, 0);
        cube = swapCW(cube, 0, 2, 1, 0, 1, 0);
        cube = swapCW(cube, 0, 2, 2, 0, 2, 0);

        cube = swapCW(cube, 1, 0, 0, 3, 0, 0);
        cube = swapCW(cube, 1, 1, 0, 3, 1, 0);
        cube = swapCW(cube, 1, 2, 0, 3, 2, 0);
        cube = swapCW(cube, 2, 0, 0, 1, 0, 0);
        cube = swapCW(cube, 2, 1, 0, 1, 1, 0);
        cube = swapCW(cube, 2, 2, 0, 1, 2, 0);
        cube = swapCW(cube, 3, 0, 0, 5, 2, 2);
        cube = swapCW(cube, 3, 1, 0, 5, 1, 2);
        cube = swapCW(cube, 3, 2, 0, 5, 0, 2);
        cube = swapCW(cube, 5, 0, 2, 2, 0, 0);
        cube = swapCW(cube, 5, 1, 2, 2, 1, 0);
        cube = swapCW(cube, 5, 2, 2, 2, 2, 0);

        return cube;
    }

    public static char[][][] WCCW(char[][][] cube) {
        cube = swapCCW(cube, 0, 0, 0, 0, 0, 2);
        cube = swapCCW(cube, 0, 0, 1, 0, 1, 2);
        cube = swapCCW(cube, 0, 0, 2, 0, 2, 2);
        cube = swapCCW(cube, 0, 1, 0, 0, 0, 1);
        cube = swapCCW(cube, 0, 1, 1, 0, 1, 1);
        cube = swapCCW(cube, 0, 1, 2, 0, 2, 1);
        cube = swapCCW(cube, 0, 2, 0, 0, 0, 0);
        cube = swapCCW(cube, 0, 2, 1, 0, 1, 0);
        cube = swapCCW(cube, 0, 2, 2, 0, 2, 0);

        cube = swapCCW(cube, 1, 0, 0, 3, 0, 0);
        cube = swapCCW(cube, 1, 1, 0, 3, 1, 0);
        cube = swapCCW(cube, 1, 2, 0, 3, 2, 0);
        cube = swapCCW(cube, 2, 0, 0, 1, 0, 0);
        cube = swapCCW(cube, 2, 1, 0, 1, 1, 0);
        cube = swapCCW(cube, 2, 2, 0, 1, 2, 0);
        cube = swapCCW(cube, 3, 0, 0, 5, 2, 2);
        cube = swapCCW(cube, 3, 1, 0, 5, 1, 2);
        cube = swapCCW(cube, 3, 2, 0, 5, 0, 2);
        cube = swapCCW(cube, 5, 0, 2, 2, 0, 0);
        cube = swapCCW(cube, 5, 1, 2, 2, 1, 0);
        cube = swapCCW(cube, 5, 2, 2, 2, 2, 0);

        return cube;
    }

    public static char[][][] BCW(char[][][] cube) {
        cube = swapCW(cube, 1, 0, 0, 1, 0, 2);
        cube = swapCW(cube, 1, 0, 1, 1, 1, 2);
        cube = swapCW(cube, 1, 0, 2, 1, 2, 2);
        cube = swapCW(cube, 1, 1, 0, 1, 0, 1);
        cube = swapCW(cube, 1, 1, 1, 1, 1, 1);
        cube = swapCW(cube, 1, 1, 2, 1, 2, 1);
        cube = swapCW(cube, 1, 2, 0, 1, 0, 0);
        cube = swapCW(cube, 1, 2, 1, 1, 1, 0);
        cube = swapCW(cube, 1, 2, 2, 1, 2, 0);

        cube = swapCW(cube, 0, 0, 2, 2, 2, 2);
        cube = swapCW(cube, 0, 1, 2, 2, 2, 1);
        cube = swapCW(cube, 0, 2, 2, 2, 2, 0);
        cube = swapCW(cube, 2, 2, 0, 4, 0, 0);
        cube = swapCW(cube, 2, 2, 1, 4, 1, 0);
        cube = swapCW(cube, 2, 2, 2, 4, 2, 0);
        cube = swapCW(cube, 3, 0, 0, 0, 0, 2);
        cube = swapCW(cube, 3, 0, 1, 0, 1, 2);
        cube = swapCW(cube, 3, 0, 2, 0, 2, 2);
        cube = swapCW(cube, 4, 0, 0, 3, 0, 2);
        cube = swapCW(cube, 4, 1, 0, 3, 0, 1);
        cube = swapCW(cube, 4, 2, 0, 3, 0, 0);

        return cube;
    }

    public static char[][][] BCCW(char[][][] cube) {
        cube = swapCCW(cube, 1, 0, 0, 1, 0, 2);
        cube = swapCCW(cube, 1, 0, 1, 1, 1, 2);
        cube = swapCCW(cube, 1, 0, 2, 1, 2, 2);
        cube = swapCCW(cube, 1, 1, 0, 1, 0, 1);
        cube = swapCCW(cube, 1, 1, 1, 1, 1, 1);
        cube = swapCCW(cube, 1, 1, 2, 1, 2, 1);
        cube = swapCCW(cube, 1, 2, 0, 1, 0, 0);
        cube = swapCCW(cube, 1, 2, 1, 1, 1, 0);
        cube = swapCCW(cube, 1, 2, 2, 1, 2, 0);

        cube = swapCCW(cube, 0, 0, 2, 2, 2, 2);
        cube = swapCCW(cube, 0, 1, 2, 2, 2, 1);
        cube = swapCCW(cube, 0, 2, 2, 2, 2, 0);
        cube = swapCCW(cube, 2, 2, 0, 4, 0, 0);
        cube = swapCCW(cube, 2, 2, 1, 4, 1, 0);
        cube = swapCCW(cube, 2, 2, 2, 4, 2, 0);
        cube = swapCCW(cube, 3, 0, 0, 0, 0, 2);
        cube = swapCCW(cube, 3, 0, 1, 0, 1, 2);
        cube = swapCCW(cube, 3, 0, 2, 0, 2, 2);
        cube = swapCCW(cube, 4, 0, 0, 3, 0, 2);
        cube = swapCCW(cube, 4, 1, 0, 3, 0, 1);
        cube = swapCCW(cube, 4, 2, 0, 3, 0, 0);

        return cube;
    }

    public static char[][][] OCW(char[][][] cube) {
        
        cube = swapCW(cube, 2, 0, 0, 2, 0, 2);
        cube = swapCW(cube, 2, 0, 1, 2, 1, 2);
        cube = swapCW(cube, 2, 0, 2, 2, 2, 2);
        cube = swapCW(cube, 2, 1, 0, 2, 0, 1);
        cube = swapCW(cube, 2, 1, 1, 2, 1, 1);
        cube = swapCW(cube, 2, 1, 2, 2, 2, 1);
        cube = swapCW(cube, 2, 2, 0, 2, 0, 0);
        cube = swapCW(cube, 2, 2, 1, 2, 1, 0);
        cube = swapCW(cube, 2, 2, 2, 2, 2, 0);

        cube = swapCW(cube, 0, 0, 0, 5, 0, 0);
        cube = swapCW(cube, 0, 0, 1, 5, 0, 1);
        cube = swapCW(cube, 0, 0, 2, 5, 0, 2);
        cube = swapCW(cube, 1, 0, 0, 0, 0, 0);
        cube = swapCW(cube, 1, 0, 1, 0, 0, 1);
        cube = swapCW(cube, 1, 0, 2, 0, 0, 2);
        cube = swapCW(cube, 4, 0, 0, 1, 0, 0);
        cube = swapCW(cube, 4, 0, 1, 1, 0, 1);
        cube = swapCW(cube, 4, 0, 2, 1, 0, 2);
        cube = swapCW(cube, 5, 0, 0, 4, 0, 0);
        cube = swapCW(cube, 5, 0, 1, 4, 0, 1);
        cube = swapCW(cube, 5, 0, 2, 4, 0, 2);

        return cube;
    }

    public static char[][][] OCCW(char[][][] cube) {
        
        cube = swapCCW(cube, 2, 0, 0, 2, 0, 2);
        cube = swapCCW(cube, 2, 0, 1, 2, 1, 2);
        cube = swapCCW(cube, 2, 0, 2, 2, 2, 2);
        cube = swapCCW(cube, 2, 1, 0, 2, 0, 1);
        cube = swapCCW(cube, 2, 1, 1, 2, 1, 1);
        cube = swapCCW(cube, 2, 1, 2, 2, 2, 1);
        cube = swapCCW(cube, 2, 2, 0, 2, 0, 0);
        cube = swapCCW(cube, 2, 2, 1, 2, 1, 0);
        cube = swapCCW(cube, 2, 2, 2, 2, 2, 0);

        cube = swapCCW(cube, 0, 0, 0, 5, 0, 0);
        cube = swapCCW(cube, 0, 0, 1, 5, 0, 1);
        cube = swapCCW(cube, 0, 0, 2, 5, 0, 2);
        cube = swapCCW(cube, 1, 0, 0, 0, 0, 0);
        cube = swapCCW(cube, 1, 0, 1, 0, 0, 1);
        cube = swapCCW(cube, 1, 0, 2, 0, 0, 2);
        cube = swapCCW(cube, 4, 0, 0, 1, 0, 0);
        cube = swapCCW(cube, 4, 0, 1, 1, 0, 1);
        cube = swapCCW(cube, 4, 0, 2, 1, 0, 2);
        cube = swapCCW(cube, 5, 0, 0, 4, 0, 0);
        cube = swapCCW(cube, 5, 0, 1, 4, 0, 1);
        cube = swapCCW(cube, 5, 0, 2, 4, 0, 2);

        return cube;
    }

    public static char[][][] RCW(char[][][] cube) {
        
        cube = swapCW(cube, 3, 0, 0, 3, 0, 2);
        cube = swapCW(cube, 3, 0, 1, 3, 1, 2);
        cube = swapCW(cube, 3, 0, 2, 3, 2, 2);
        cube = swapCW(cube, 3, 1, 0, 3, 0, 1);
        cube = swapCW(cube, 3, 1, 1, 3, 1, 1);
        cube = swapCW(cube, 3, 1, 2, 3, 2, 1);
        cube = swapCW(cube, 3, 2, 0, 3, 0, 0);
        cube = swapCW(cube, 3, 2, 1, 3, 1, 0);
        cube = swapCW(cube, 3, 2, 2, 3, 2, 0);

        cube = swapCW(cube, 0, 2, 0, 1, 2, 0);
        cube = swapCW(cube, 0, 2, 1, 1, 2, 1);
        cube = swapCW(cube, 0, 2, 2, 1, 2, 2);
        cube = swapCW(cube, 1, 2, 0, 4, 2, 0);
        cube = swapCW(cube, 1, 2, 1, 4, 2, 1);
        cube = swapCW(cube, 1, 2, 2, 4, 2, 2);
        cube = swapCW(cube, 4, 2, 0, 5, 2, 0);
        cube = swapCW(cube, 4, 2, 1, 5, 2, 1);
        cube = swapCW(cube, 4, 2, 2, 5, 2, 2);
        cube = swapCW(cube, 5, 2, 0, 0, 2, 0);
        cube = swapCW(cube, 5, 2, 1, 0, 2, 1);
        cube = swapCW(cube, 5, 2, 2, 0, 2, 2);

        return cube;
    }

    public static char[][][] RCCW(char[][][] cube) {
        
        cube = swapCCW(cube, 3, 0, 0, 3, 0, 2);
        cube = swapCCW(cube, 3, 0, 1, 3, 1, 2);
        cube = swapCCW(cube, 3, 0, 2, 3, 2, 2);
        cube = swapCCW(cube, 3, 1, 0, 3, 0, 1);
        cube = swapCCW(cube, 3, 1, 1, 3, 1, 1);
        cube = swapCCW(cube, 3, 1, 2, 3, 2, 1);
        cube = swapCCW(cube, 3, 2, 0, 3, 0, 0);
        cube = swapCCW(cube, 3, 2, 1, 3, 1, 0);
        cube = swapCCW(cube, 3, 2, 2, 3, 2, 0);

        cube = swapCCW(cube, 0, 2, 0, 1, 2, 0);
        cube = swapCCW(cube, 0, 2, 1, 1, 2, 1);
        cube = swapCCW(cube, 0, 2, 2, 1, 2, 2);
        cube = swapCCW(cube, 1, 2, 0, 4, 2, 0);
        cube = swapCCW(cube, 1, 2, 1, 4, 2, 1);
        cube = swapCCW(cube, 1, 2, 2, 4, 2, 2);
        cube = swapCCW(cube, 4, 2, 0, 5, 2, 0);
        cube = swapCCW(cube, 4, 2, 1, 5, 2, 1);
        cube = swapCCW(cube, 4, 2, 2, 5, 2, 2);
        cube = swapCCW(cube, 5, 2, 0, 0, 2, 0);
        cube = swapCCW(cube, 5, 2, 1, 0, 2, 1);
        cube = swapCCW(cube, 5, 2, 2, 0, 2, 2);

        return cube;
    }

    public static char[][][] YCW(char[][][] cube) {

        cube = swapCW(cube, 4, 0, 0, 4, 0, 2);
        cube = swapCW(cube, 4, 0, 1, 4, 1, 2);
        cube = swapCW(cube, 4, 0, 2, 4, 2, 2);
        cube = swapCW(cube, 4, 1, 0, 4, 0, 1);
        cube = swapCW(cube, 4, 1, 1, 4, 1, 1);
        cube = swapCW(cube, 4, 1, 2, 4, 2, 1);
        cube = swapCW(cube, 4, 2, 0, 4, 0, 0);
        cube = swapCW(cube, 4, 2, 1, 4, 1, 0);
        cube = swapCW(cube, 4, 2, 2, 4, 2, 0);

        cube = swapCW(cube, 1, 0, 2, 2, 0, 2);
        cube = swapCW(cube, 1, 1, 2, 2, 1, 2);
        cube = swapCW(cube, 1, 2, 2, 2, 2, 2);
        cube = swapCW(cube, 2, 0, 2, 5, 2, 0);
        cube = swapCW(cube, 2, 1, 2, 5, 1, 0);
        cube = swapCW(cube, 2, 2, 2, 5, 0, 0);
        cube = swapCW(cube, 3, 0, 2, 1, 0, 2);
        cube = swapCW(cube, 3, 1, 2, 1, 1, 2);
        cube = swapCW(cube, 3, 2, 2, 1, 2, 2);
        cube = swapCW(cube, 5, 0, 0, 3, 2, 2);
        cube = swapCW(cube, 5, 1, 0, 3, 1, 2);
        cube = swapCW(cube, 5, 2, 0, 3, 0, 2);

        return cube;
    }

    public static char[][][] YCCW(char[][][] cube) {
        
        cube = swapCCW(cube, 4, 0, 0, 4, 0, 2);
        cube = swapCCW(cube, 4, 0, 1, 4, 1, 2);
        cube = swapCCW(cube, 4, 0, 2, 4, 2, 2);
        cube = swapCCW(cube, 4, 1, 0, 4, 0, 1);
        cube = swapCCW(cube, 4, 1, 1, 4, 1, 1);
        cube = swapCCW(cube, 4, 1, 2, 4, 2, 1);
        cube = swapCCW(cube, 4, 2, 0, 4, 0, 0);
        cube = swapCCW(cube, 4, 2, 1, 4, 1, 0);
        cube = swapCCW(cube, 4, 2, 2, 4, 2, 0);

        cube = swapCCW(cube, 1, 0, 2, 2, 0, 2);
        cube = swapCCW(cube, 1, 1, 2, 2, 1, 2);
        cube = swapCCW(cube, 1, 2, 2, 2, 2, 2);
        cube = swapCCW(cube, 2, 0, 2, 5, 2, 0);
        cube = swapCCW(cube, 2, 1, 2, 5, 1, 0);
        cube = swapCCW(cube, 2, 2, 2, 5, 0, 0);
        cube = swapCCW(cube, 3, 0, 2, 1, 0, 2);
        cube = swapCCW(cube, 3, 1, 2, 1, 1, 2);
        cube = swapCCW(cube, 3, 2, 2, 1, 2, 2);
        cube = swapCCW(cube, 5, 0, 0, 3, 2, 2);
        cube = swapCCW(cube, 5, 1, 0, 3, 1, 2);
        cube = swapCCW(cube, 5, 2, 0, 3, 0, 2);

        return cube;
    }

    public static char[][][] GCW(char[][][] cube) {

        cube = swapCW(cube, 5, 0, 0, 5, 0, 2);
        cube = swapCW(cube, 5, 0, 1, 5, 1, 2);
        cube = swapCW(cube, 5, 0, 2, 5, 2, 2);
        cube = swapCW(cube, 5, 1, 0, 5, 0, 1);
        cube = swapCW(cube, 5, 1, 1, 5, 1, 1);
        cube = swapCW(cube, 5, 1, 2, 5, 2, 1);
        cube = swapCW(cube, 5, 2, 0, 5, 0, 0);
        cube = swapCW(cube, 5, 2, 1, 5, 1, 0);
        cube = swapCW(cube, 5, 2, 2, 5, 2, 0);

        cube = swapCW(cube, 0, 0, 0, 3, 2, 0);
        cube = swapCW(cube, 0, 1, 0, 3, 2, 1);
        cube = swapCW(cube, 0, 2, 0, 3, 2, 2);
        cube = swapCW(cube, 2, 0, 0, 0, 2, 0);
        cube = swapCW(cube, 2, 0, 1, 0, 1, 0);
        cube = swapCW(cube, 2, 0, 2, 0, 0, 0);
        cube = swapCW(cube, 3, 2, 0, 4, 2, 2);
        cube = swapCW(cube, 3, 2, 1, 4, 1, 2);
        cube = swapCW(cube, 3, 2, 2, 4, 0, 2);
        cube = swapCW(cube, 4, 0, 2, 2, 0, 0);
        cube = swapCW(cube, 4, 1, 2, 2, 0, 1);
        cube = swapCW(cube, 4, 2, 2, 2, 0, 2);

        return cube;
    }

    public static char[][][] GCCW(char[][][] cube) {

        cube = swapCCW(cube, 5, 0, 0, 5, 0, 2);
        cube = swapCCW(cube, 5, 0, 1, 5, 1, 2);
        cube = swapCCW(cube, 5, 0, 2, 5, 2, 2);
        cube = swapCCW(cube, 5, 1, 0, 5, 0, 1);
        cube = swapCCW(cube, 5, 1, 1, 5, 1, 1);
        cube = swapCCW(cube, 5, 1, 2, 5, 2, 1);
        cube = swapCCW(cube, 5, 2, 0, 5, 0, 0);
        cube = swapCCW(cube, 5, 2, 1, 5, 1, 0);
        cube = swapCCW(cube, 5, 2, 2, 5, 2, 0);

        cube = swapCCW(cube, 0, 0, 0, 3, 2, 0);
        cube = swapCCW(cube, 0, 1, 0, 3, 2, 1);
        cube = swapCCW(cube, 0, 2, 0, 3, 2, 2);
        cube = swapCCW(cube, 2, 0, 0, 0, 2, 0);
        cube = swapCCW(cube, 2, 0, 1, 0, 1, 0);
        cube = swapCCW(cube, 2, 0, 2, 0, 0, 0);
        cube = swapCCW(cube, 3, 2, 0, 4, 2, 2);
        cube = swapCCW(cube, 3, 2, 1, 4, 1, 2);
        cube = swapCCW(cube, 3, 2, 2, 4, 0, 2);
        cube = swapCCW(cube, 4, 0, 2, 2, 0, 0);
        cube = swapCCW(cube, 4, 1, 2, 2, 0, 1);
        cube = swapCCW(cube, 4, 2, 2, 2, 0, 2);
        
        return cube;
    }
}
