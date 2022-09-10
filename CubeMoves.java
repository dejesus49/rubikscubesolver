package rubikscubesolver;


public class CubeMoves {
    /*
    // private static char[][][] swapCW(char[][][] cube, int i1, int j1, int k1, int i2, int j2, int k2) {
    //     char temp = cube[i1][j1][k1];
    //     cube[i1][j1][k1] = cube[i2][j2][k2];
    //     cube[i2][j2][k2] = temp;
    //     return cube;
    // }

    // private static char[][][] swapCCW(char[][][] cube, int i2, int j2, int k2, int i1, int j1, int k1) {
    //     char temp = cube[i1][j1][k1];
    //     cube[i1][j1][k1] = cube[i2][j2][k2];
    //     cube[i2][j2][k2] = temp;
    //     return cube;
    // }

    // private static char[][][] copyCube(char[][][] cube) {
    //     char[][][] cubeCopy = new char[6][3][3];
    //     for (int i = 0; i < 6; ++i) {
    //         for (int j = 0; j < 3; ++j) {
    //             for (int k = 0; k < 3; ++k) {
    //                 cubeCopy[i][j][k] = cube[i][j][k];
    //             }
    //         }
    //     }
    //     return cubeCopy;
    // }
    */

    public static char[][][] WCW(char[][][] cube) {

        // char[] tempMainFace = new char[3];
        // char[] tempSideFace = new char[3];
        // for (int i = 0; i < 3; ++i) {
        //     tempMainFace[i] = cube[0][0][i];
        // }
        // for (int i = 0; i < 3; ++i) {
        //     tempMainFace[i] = cube[0][0][i];
        //     cube[0][0][i] = cube[0][2-i][0];
        //     cube[0][1][i] = cube[0][2-i][1];
        //     cube[0][2][i] = cube[0][2-i][2];
        // }

        char tempEdge = cube[0][0][1];
        cube[0][0][1] = cube[0][1][0];
        cube[0][1][0] = cube[0][2][1];
        cube[0][2][1] = cube[0][1][2];
        cube[0][1][2] = tempEdge;
        char tempCorner = cube[0][0][0];
        cube[0][0][0] = cube[0][2][0];
        cube[0][2][0] = cube[0][2][2];
        cube[0][2][2] = cube[0][0][2];
        cube[0][0][2] = tempCorner;

        char[] tempSideFace = new char[3];
        for (int i = 0; i < 3; ++i) {
            tempSideFace[i] = cube[1][i][0];
            cube[1][i][0] = cube[2][i][0];
            cube[2][i][0] = cube[5][i][2];
            cube[5][i][2] = cube[3][2-i][0];
        }
        for (int i = 0; i <3; ++i) {
            cube[3][i][0] = tempSideFace[i];
        }
        /*
        // cube = swapCW(cube, 0, 0, 0, 0, 0, 2);
        // cube = swapCW(cube, 0, 0, 1, 0, 1, 2);
        // cube = swapCW(cube, 0, 0, 2, 0, 2, 2);
        // cube = swapCW(cube, 0, 1, 0, 0, 0, 1);
        // cube = swapCW(cube, 0, 1, 2, 0, 2, 1);
        // cube = swapCW(cube, 0, 2, 0, 0, 0, 0);
        // cube = swapCW(cube, 0, 2, 1, 0, 1, 0);
        // cube = swapCW(cube, 0, 2, 2, 0, 2, 0);

        // cube = swapCW(cube, 1, 0, 0, 3, 0, 0);
        // cube = swapCW(cube, 1, 1, 0, 3, 1, 0);
        // cube = swapCW(cube, 1, 2, 0, 3, 2, 0);

        // cube = swapCW(cube, 2, 0, 0, 1, 0, 0);
        // cube = swapCW(cube, 2, 1, 0, 1, 1, 0);
        // cube = swapCW(cube, 2, 2, 0, 1, 2, 0);

        // cube = swapCW(cube, 3, 0, 0, 5, 2, 2);
        // cube = swapCW(cube, 3, 1, 0, 5, 1, 2);
        // cube = swapCW(cube, 3, 2, 0, 5, 0, 2);

        // cube = swapCW(cube, 5, 0, 2, 2, 0, 0);
        // cube = swapCW(cube, 5, 1, 2, 2, 1, 0);
        // cube = swapCW(cube, 5, 2, 2, 2, 2, 0);
        */
        return cube;
    }

    public static char[][][] WCCW(char[][][] cube) {

        char tempEdge = cube[0][0][1];
        cube[0][0][1] = cube[0][1][2];
        cube[0][1][2] = cube[0][2][1];
        cube[0][2][1] = cube[0][1][0];
        cube[0][1][0] = tempEdge;
        char tempCorner = cube[0][0][0];
        cube[0][0][0] = cube[0][0][2];
        cube[0][0][2] = cube[0][2][2];
        cube[0][2][2] = cube[0][2][0];
        cube[0][2][0] = tempCorner;

        char[] tempSideFace = new char[3];
        for (int i = 0; i < 3; ++i) {
            tempSideFace[i] = cube[1][i][0];
            cube[1][i][0] = cube[3][i][0];
            cube[3][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[2][2-i][0];
        }
        for (int i = 0; i <3; ++i) {
            cube[2][i][0] = tempSideFace[i];
        }
        /*
        // cube = swapCCW(cube, 0, 0, 0, 0, 0, 2);
        // cube = swapCCW(cube, 0, 0, 1, 0, 1, 2);
        // cube = swapCCW(cube, 0, 0, 2, 0, 2, 2);
        // cube = swapCCW(cube, 0, 1, 0, 0, 0, 1);
        // cube = swapCCW(cube, 0, 1, 2, 0, 2, 1);
        // cube = swapCCW(cube, 0, 2, 0, 0, 0, 0);
        // cube = swapCCW(cube, 0, 2, 1, 0, 1, 0);
        // cube = swapCCW(cube, 0, 2, 2, 0, 2, 0);

        // cube = swapCCW(cube, 1, 0, 0, 3, 0, 0);
        // cube = swapCCW(cube, 1, 1, 0, 3, 1, 0);
        // cube = swapCCW(cube, 1, 2, 0, 3, 2, 0);

        // cube = swapCCW(cube, 2, 0, 0, 1, 0, 0);
        // cube = swapCCW(cube, 2, 1, 0, 1, 1, 0);
        // cube = swapCCW(cube, 2, 2, 0, 1, 2, 0);

        // cube = swapCCW(cube, 3, 0, 0, 5, 2, 2);
        // cube = swapCCW(cube, 3, 1, 0, 5, 1, 2);
        // cube = swapCCW(cube, 3, 2, 0, 5, 0, 2);

        // cube = swapCCW(cube, 5, 0, 2, 2, 0, 0);
        // cube = swapCCW(cube, 5, 1, 2, 2, 1, 0);
        // cube = swapCCW(cube, 5, 2, 2, 2, 2, 0);
        */
        return cube;
    }

    public static char[][][] BCW(char[][][] cube) {
        
        char tempEdge = cube[1][0][1];
        cube[1][0][1] = cube[1][1][0];
        cube[1][1][0] = cube[1][2][1];
        cube[1][2][1] = cube[1][1][2];
        cube[1][1][2] = tempEdge;
        char tempCorner = cube[1][0][0];
        cube[1][0][0] = cube[1][2][0];
        cube[1][2][0] = cube[1][2][2];
        cube[1][2][2] = cube[1][0][2];
        cube[1][0][2] = tempCorner;

        char[] tempSideFace = new char[3];
        for (int i = 0; i < 3; ++i) {
            tempSideFace[i] = cube[0][i][2];
            cube[0][i][2] = cube[3][0][i];
            cube[3][0][i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[2][2][2-i];
        }
        for (int i = 0; i <3; ++i) {
            cube[2][2][i] = tempSideFace[2-i];
        }
        /*
        // cube = swapCW(cube, 1, 0, 0, 1, 0, 2);
        // cube = swapCW(cube, 1, 0, 1, 1, 1, 2);
        // cube = swapCW(cube, 1, 0, 2, 1, 2, 2);
        // cube = swapCW(cube, 1, 1, 0, 1, 0, 1);
        // cube = swapCW(cube, 1, 1, 2, 1, 2, 1);
        // cube = swapCW(cube, 1, 2, 0, 1, 0, 0);
        // cube = swapCW(cube, 1, 2, 1, 1, 1, 0);
        // cube = swapCW(cube, 1, 2, 2, 1, 2, 0);

        // cube = swapCW(cube, 0, 0, 2, 2, 2, 2);
        // cube = swapCW(cube, 0, 1, 2, 2, 2, 1);
        // cube = swapCW(cube, 0, 2, 2, 2, 2, 0);

        // cube = swapCW(cube, 2, 2, 0, 4, 0, 0);
        // cube = swapCW(cube, 2, 2, 1, 4, 1, 0);
        // cube = swapCW(cube, 2, 2, 2, 4, 2, 0);

        // cube = swapCW(cube, 3, 0, 0, 0, 0, 2);
        // cube = swapCW(cube, 3, 0, 1, 0, 1, 2);
        // cube = swapCW(cube, 3, 0, 2, 0, 2, 2);

        // cube = swapCW(cube, 4, 0, 0, 3, 0, 2);
        // cube = swapCW(cube, 4, 1, 0, 3, 0, 1);
        // cube = swapCW(cube, 4, 2, 0, 3, 0, 0);
        */
        return cube;
    }

    public static char[][][] BCCW(char[][][] cube) {

        char tempEdge = cube[1][0][1];
        cube[1][0][1] = cube[1][1][2];
        cube[1][1][2] = cube[1][2][1];
        cube[1][2][1] = cube[1][1][0];
        cube[1][1][0] = tempEdge;
        char tempCorner = cube[1][0][0];
        cube[1][0][0] = cube[1][0][2];
        cube[1][0][2] = cube[1][2][2];
        cube[1][2][2] = cube[1][2][0];
        cube[1][2][0] = tempCorner;

        char[] tempSideFace = new char[3];
        for (int i = 0; i < 3; ++i) {
            tempSideFace[i] = cube[0][i][2];
            cube[0][i][2] = cube[2][2][2-i];
            cube[2][2][2-i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[3][0][i];
        }
        for (int i = 0; i <3; ++i) {
            cube[3][0][i] = tempSideFace[i];
        }
        /*
        // cube = swapCCW(cube, 1, 0, 0, 1, 0, 2);
        // cube = swapCCW(cube, 1, 0, 1, 1, 1, 2);
        // cube = swapCCW(cube, 1, 0, 2, 1, 2, 2);
        // cube = swapCCW(cube, 1, 1, 0, 1, 0, 1);
        // cube = swapCCW(cube, 1, 1, 2, 1, 2, 1);
        // cube = swapCCW(cube, 1, 2, 0, 1, 0, 0);
        // cube = swapCCW(cube, 1, 2, 1, 1, 1, 0);
        // cube = swapCCW(cube, 1, 2, 2, 1, 2, 0);

        // cube = swapCCW(cube, 0, 0, 2, 2, 2, 2);
        // cube = swapCCW(cube, 0, 1, 2, 2, 2, 1);
        // cube = swapCCW(cube, 0, 2, 2, 2, 2, 0);

        // cube = swapCCW(cube, 2, 2, 0, 4, 0, 0);
        // cube = swapCCW(cube, 2, 2, 1, 4, 1, 0);
        // cube = swapCCW(cube, 2, 2, 2, 4, 2, 0);

        // cube = swapCCW(cube, 3, 0, 0, 0, 0, 2);
        // cube = swapCCW(cube, 3, 0, 1, 0, 1, 2);
        // cube = swapCCW(cube, 3, 0, 2, 0, 2, 2);

        // cube = swapCCW(cube, 4, 0, 0, 3, 0, 2);
        // cube = swapCCW(cube, 4, 1, 0, 3, 0, 1);
        // cube = swapCCW(cube, 4, 2, 0, 3, 0, 0);
        */
        return cube;
    }

    public static char[][][] OCW(char[][][] cube) {
        
        // cube = swapCW(cube, 2, 0, 0, 2, 0, 2);
        // cube = swapCW(cube, 2, 0, 1, 2, 1, 2);
        // cube = swapCW(cube, 2, 0, 2, 2, 2, 2);
        // cube = swapCW(cube, 2, 1, 0, 2, 0, 1);
        // cube = swapCW(cube, 2, 1, 2, 2, 2, 1);
        // cube = swapCW(cube, 2, 2, 0, 2, 0, 0);
        // cube = swapCW(cube, 2, 2, 1, 2, 1, 0);
        // cube = swapCW(cube, 2, 2, 2, 2, 2, 0);

        // cube = swapCW(cube, 0, 0, 0, 5, 0, 0);
        // cube = swapCW(cube, 0, 0, 1, 5, 0, 1);
        // cube = swapCW(cube, 0, 0, 2, 5, 0, 2);

        // cube = swapCW(cube, 1, 0, 0, 0, 0, 0);
        // cube = swapCW(cube, 1, 0, 1, 0, 0, 1);
        // cube = swapCW(cube, 1, 0, 2, 0, 0, 2);

        // cube = swapCW(cube, 4, 0, 0, 1, 0, 0);
        // cube = swapCW(cube, 4, 0, 1, 1, 0, 1);
        // cube = swapCW(cube, 4, 0, 2, 1, 0, 2);

        // cube = swapCW(cube, 5, 0, 0, 4, 0, 0);
        // cube = swapCW(cube, 5, 0, 1, 4, 0, 1);
        // cube = swapCW(cube, 5, 0, 2, 4, 0, 2);

        return cube;
    }

    public static char[][][] OCCW(char[][][] cube) {
        
        // cube = swapCCW(cube, 2, 0, 0, 2, 0, 2);
        // cube = swapCCW(cube, 2, 0, 1, 2, 1, 2);
        // cube = swapCCW(cube, 2, 0, 2, 2, 2, 2);
        // cube = swapCCW(cube, 2, 1, 0, 2, 0, 1);
        // cube = swapCCW(cube, 2, 1, 2, 2, 2, 1);
        // cube = swapCCW(cube, 2, 2, 0, 2, 0, 0);
        // cube = swapCCW(cube, 2, 2, 1, 2, 1, 0);
        // cube = swapCCW(cube, 2, 2, 2, 2, 2, 0);

        // cube = swapCCW(cube, 0, 0, 0, 5, 0, 0);
        // cube = swapCCW(cube, 0, 0, 1, 5, 0, 1);
        // cube = swapCCW(cube, 0, 0, 2, 5, 0, 2);

        // cube = swapCCW(cube, 1, 0, 0, 0, 0, 0);
        // cube = swapCCW(cube, 1, 0, 1, 0, 0, 1);
        // cube = swapCCW(cube, 1, 0, 2, 0, 0, 2);

        // cube = swapCCW(cube, 4, 0, 0, 1, 0, 0);
        // cube = swapCCW(cube, 4, 0, 1, 1, 0, 1);
        // cube = swapCCW(cube, 4, 0, 2, 1, 0, 2);

        // cube = swapCCW(cube, 5, 0, 0, 4, 0, 0);
        // cube = swapCCW(cube, 5, 0, 1, 4, 0, 1);
        // cube = swapCCW(cube, 5, 0, 2, 4, 0, 2);

        return cube;
    }

    public static char[][][] RCW(char[][][] cube) {
        
        // cube = swapCW(cube, 3, 0, 0, 3, 0, 2);
        // cube = swapCW(cube, 3, 0, 1, 3, 1, 2);
        // cube = swapCW(cube, 3, 0, 2, 3, 2, 2);
        // cube = swapCW(cube, 3, 1, 0, 3, 0, 1);
        // cube = swapCW(cube, 3, 1, 2, 3, 2, 1);
        // cube = swapCW(cube, 3, 2, 0, 3, 0, 0);
        // cube = swapCW(cube, 3, 2, 1, 3, 1, 0);
        // cube = swapCW(cube, 3, 2, 2, 3, 2, 0);

        // cube = swapCW(cube, 0, 2, 0, 1, 2, 0);
        // cube = swapCW(cube, 0, 2, 1, 1, 2, 1);
        // cube = swapCW(cube, 0, 2, 2, 1, 2, 2);

        // cube = swapCW(cube, 1, 2, 0, 4, 2, 0);
        // cube = swapCW(cube, 1, 2, 1, 4, 2, 1);
        // cube = swapCW(cube, 1, 2, 2, 4, 2, 2);

        // cube = swapCW(cube, 4, 2, 0, 5, 2, 0);
        // cube = swapCW(cube, 4, 2, 1, 5, 2, 1);
        // cube = swapCW(cube, 4, 2, 2, 5, 2, 2);

        // cube = swapCW(cube, 5, 2, 0, 0, 2, 0);
        // cube = swapCW(cube, 5, 2, 1, 0, 2, 1);
        // cube = swapCW(cube, 5, 2, 2, 0, 2, 2);

        return cube;
    }

    public static char[][][] RCCW(char[][][] cube) {
        
        // cube = swapCCW(cube, 3, 0, 0, 3, 0, 2);
        // cube = swapCCW(cube, 3, 0, 1, 3, 1, 2);
        // cube = swapCCW(cube, 3, 0, 2, 3, 2, 2);
        // cube = swapCCW(cube, 3, 1, 0, 3, 0, 1);
        // cube = swapCCW(cube, 3, 1, 2, 3, 2, 1);
        // cube = swapCCW(cube, 3, 2, 0, 3, 0, 0);
        // cube = swapCCW(cube, 3, 2, 1, 3, 1, 0);
        // cube = swapCCW(cube, 3, 2, 2, 3, 2, 0);

        // cube = swapCCW(cube, 0, 2, 0, 1, 2, 0);
        // cube = swapCCW(cube, 0, 2, 1, 1, 2, 1);
        // cube = swapCCW(cube, 0, 2, 2, 1, 2, 2);

        // cube = swapCCW(cube, 1, 2, 0, 4, 2, 0);
        // cube = swapCCW(cube, 1, 2, 1, 4, 2, 1);
        // cube = swapCCW(cube, 1, 2, 2, 4, 2, 2);

        // cube = swapCCW(cube, 4, 2, 0, 5, 2, 0);
        // cube = swapCCW(cube, 4, 2, 1, 5, 2, 1);
        // cube = swapCCW(cube, 4, 2, 2, 5, 2, 2);

        // cube = swapCCW(cube, 5, 2, 0, 0, 2, 0);
        // cube = swapCCW(cube, 5, 2, 1, 0, 2, 1);
        // cube = swapCCW(cube, 5, 2, 2, 0, 2, 2);

        return cube;
    }

    public static char[][][] YCW(char[][][] cube) {

        // cube = swapCW(cube, 4, 0, 0, 4, 0, 2);
        // cube = swapCW(cube, 4, 0, 1, 4, 1, 2);
        // cube = swapCW(cube, 4, 0, 2, 4, 2, 2);
        // cube = swapCW(cube, 4, 1, 0, 4, 0, 1);
        // cube = swapCW(cube, 4, 1, 2, 4, 2, 1);
        // cube = swapCW(cube, 4, 2, 0, 4, 0, 0);
        // cube = swapCW(cube, 4, 2, 1, 4, 1, 0);
        // cube = swapCW(cube, 4, 2, 2, 4, 2, 0);

        // cube = swapCW(cube, 1, 0, 2, 2, 0, 2);
        // cube = swapCW(cube, 1, 1, 2, 2, 1, 2);
        // cube = swapCW(cube, 1, 2, 2, 2, 2, 2);

        // cube = swapCW(cube, 2, 0, 2, 5, 2, 0);
        // cube = swapCW(cube, 2, 1, 2, 5, 1, 0);
        // cube = swapCW(cube, 2, 2, 2, 5, 0, 0);

        // cube = swapCW(cube, 3, 0, 2, 1, 0, 2);
        // cube = swapCW(cube, 3, 1, 2, 1, 1, 2);
        // cube = swapCW(cube, 3, 2, 2, 1, 2, 2);

        // cube = swapCW(cube, 5, 0, 0, 3, 2, 2);
        // cube = swapCW(cube, 5, 1, 0, 3, 1, 2);
        // cube = swapCW(cube, 5, 2, 0, 3, 0, 2);

        return cube;
    }

    public static char[][][] YCCW(char[][][] cube) {
        
        // cube = swapCCW(cube, 4, 0, 0, 4, 0, 2);
        // cube = swapCCW(cube, 4, 0, 1, 4, 1, 2);
        // cube = swapCCW(cube, 4, 0, 2, 4, 2, 2);
        // cube = swapCCW(cube, 4, 1, 0, 4, 0, 1);
        // cube = swapCCW(cube, 4, 1, 2, 4, 2, 1);
        // cube = swapCCW(cube, 4, 2, 0, 4, 0, 0);
        // cube = swapCCW(cube, 4, 2, 1, 4, 1, 0);
        // cube = swapCCW(cube, 4, 2, 2, 4, 2, 0);

        // cube = swapCCW(cube, 1, 0, 2, 2, 0, 2);
        // cube = swapCCW(cube, 1, 1, 2, 2, 1, 2);
        // cube = swapCCW(cube, 1, 2, 2, 2, 2, 2);

        // cube = swapCCW(cube, 2, 0, 2, 5, 2, 0);
        // cube = swapCCW(cube, 2, 1, 2, 5, 1, 0);
        // cube = swapCCW(cube, 2, 2, 2, 5, 0, 0);

        // cube = swapCCW(cube, 3, 0, 2, 1, 0, 2);
        // cube = swapCCW(cube, 3, 1, 2, 1, 1, 2);
        // cube = swapCCW(cube, 3, 2, 2, 1, 2, 2);

        // cube = swapCCW(cube, 5, 0, 0, 3, 2, 2);
        // cube = swapCCW(cube, 5, 1, 0, 3, 1, 2);
        // cube = swapCCW(cube, 5, 2, 0, 3, 0, 2);

        return cube;
    }

    public static char[][][] GCW(char[][][] cube) {

        // cube = swapCW(cube, 5, 0, 0, 5, 0, 2);
        // cube = swapCW(cube, 5, 0, 1, 5, 1, 2);
        // cube = swapCW(cube, 5, 0, 2, 5, 2, 2);
        // cube = swapCW(cube, 5, 1, 0, 5, 0, 1);
        // cube = swapCW(cube, 5, 1, 2, 5, 2, 1);
        // cube = swapCW(cube, 5, 2, 0, 5, 0, 0);
        // cube = swapCW(cube, 5, 2, 1, 5, 1, 0);
        // cube = swapCW(cube, 5, 2, 2, 5, 2, 0);

        // cube = swapCW(cube, 0, 0, 0, 3, 2, 0);
        // cube = swapCW(cube, 0, 1, 0, 3, 2, 1);
        // cube = swapCW(cube, 0, 2, 0, 3, 2, 2);

        // cube = swapCW(cube, 2, 0, 0, 0, 2, 0);
        // cube = swapCW(cube, 2, 0, 1, 0, 1, 0);
        // cube = swapCW(cube, 2, 0, 2, 0, 0, 0);

        // cube = swapCW(cube, 3, 2, 0, 4, 2, 2);
        // cube = swapCW(cube, 3, 2, 1, 4, 1, 2);
        // cube = swapCW(cube, 3, 2, 2, 4, 0, 2);

        // cube = swapCW(cube, 4, 0, 2, 2, 0, 0);
        // cube = swapCW(cube, 4, 1, 2, 2, 0, 1);
        // cube = swapCW(cube, 4, 2, 2, 2, 0, 2);

        return cube;
    }

    public static char[][][] GCCW(char[][][] cube) {

        // cube = swapCCW(cube, 5, 0, 0, 5, 0, 2);
        // cube = swapCCW(cube, 5, 0, 1, 5, 1, 2);
        // cube = swapCCW(cube, 5, 0, 2, 5, 2, 2);
        // cube = swapCCW(cube, 5, 1, 0, 5, 0, 1);
        // cube = swapCCW(cube, 5, 1, 2, 5, 2, 1);
        // cube = swapCCW(cube, 5, 2, 0, 5, 0, 0);
        // cube = swapCCW(cube, 5, 2, 1, 5, 1, 0);
        // cube = swapCCW(cube, 5, 2, 2, 5, 2, 0);

        // cube = swapCCW(cube, 0, 0, 0, 3, 2, 0);
        // cube = swapCCW(cube, 0, 1, 0, 3, 2, 1);
        // cube = swapCCW(cube, 0, 2, 0, 3, 2, 2);

        // cube = swapCCW(cube, 2, 0, 0, 0, 2, 0);
        // cube = swapCCW(cube, 2, 0, 1, 0, 1, 0);
        // cube = swapCCW(cube, 2, 0, 2, 0, 0, 0);

        // cube = swapCCW(cube, 3, 2, 0, 4, 2, 2);
        // cube = swapCCW(cube, 3, 2, 1, 4, 1, 2);
        // cube = swapCCW(cube, 3, 2, 2, 4, 0, 2);

        // cube = swapCCW(cube, 4, 0, 2, 2, 0, 0);
        // cube = swapCCW(cube, 4, 1, 2, 2, 0, 1);
        // cube = swapCCW(cube, 4, 2, 2, 2, 0, 2);
        
        return cube;
    }
}
