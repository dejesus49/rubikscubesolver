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

    private static char[][][] mainFaceCW(char[][][] cube, int mainFace) {
        char tempEdge = cube[mainFace][0][1];
        cube[mainFace][0][1] = cube[mainFace][1][0];
        cube[mainFace][1][0] = cube[mainFace][2][1];
        cube[mainFace][2][1] = cube[mainFace][1][2];
        cube[mainFace][1][2] = tempEdge;
        char tempCorner = cube[mainFace][0][0];
        cube[mainFace][0][0] = cube[mainFace][2][0];
        cube[mainFace][2][0] = cube[mainFace][2][2];
        cube[mainFace][2][2] = cube[mainFace][0][2];
        cube[mainFace][0][2] = tempCorner;

        return cube;
    }

    private static char[][][] mainFaceCCW(char[][][] cube, int mainFace) {
        char tempEdge = cube[mainFace][0][1];
        cube[mainFace][0][1] = cube[mainFace][1][2];
        cube[mainFace][1][2] = cube[mainFace][2][1];
        cube[mainFace][2][1] = cube[mainFace][1][0];
        cube[mainFace][1][0] = tempEdge;
        char tempCorner = cube[mainFace][0][0];
        cube[mainFace][0][0] = cube[mainFace][0][2];
        cube[mainFace][0][2] = cube[mainFace][2][2];
        cube[mainFace][2][2] = cube[mainFace][2][0];
        cube[mainFace][2][0] = tempCorner;

        return cube;
    }

    public static char[][][] WCW(char[][][] cube) {
        /*
        char[] tempMainFace = new char[3];
        char[] tempSideFace = new char[3];
        for (int i = 0; i < 3; ++i) {
            tempMainFace[i] = cube[0][0][i];
        }
        for (int i = 0; i < 3; ++i) {
            tempMainFace[i] = cube[0][0][i];
            cube[0][0][i] = cube[0][2-i][0];
            cube[0][1][i] = cube[0][2-i][1];
            cube[0][2][i] = cube[0][2-i][2];
        // }
        */
        /*
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
        */
        cube = mainFaceCW(cube, 0);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[1][i][0];
            temp = cube[1][i][0];
            cube[1][i][0] = cube[2][i][0];
            cube[2][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[3][i][0];
            // cube[3][i][0] = tempSideFace[i];
            cube[3][i][0] = temp;
        }
        /*
        // for (int i = 0; i <3; ++i) {
        //     cube[3][i][0] = tempSideFace[i];
        // }
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
        /*
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
        */
        cube = mainFaceCCW(cube, 0);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[1][i][0];
            temp = cube[1][i][0];
            cube[1][i][0] = cube[3][i][0];
            cube[3][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[2][i][0];
            // cube[2][i][0] = tempSideFace[i];
            cube[2][i][0] = temp;
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
        /*
        // char tempEdge = cube[1][0][1];
        // cube[1][0][1] = cube[1][1][0];
        // cube[1][1][0] = cube[1][2][1];
        // cube[1][2][1] = cube[1][1][2];
        // cube[1][1][2] = tempEdge;
        // char tempCorner = cube[1][0][0];
        // cube[1][0][0] = cube[1][2][0];
        // cube[1][2][0] = cube[1][2][2];
        // cube[1][2][2] = cube[1][0][2];
        // cube[1][0][2] = tempCorner;
        */
        cube = mainFaceCW(cube, 1);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[0][i][2];
            temp = cube[0][i][2];
            cube[0][i][2] = cube[3][0][i];
            cube[3][0][i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[2][2][2-i];
            // cube[2][2][2-i] = tempSideFace[i];
            cube[2][2][2-i] = temp;
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
        /*
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
        */
        cube = mainFaceCCW(cube, 1);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[0][i][2];
            temp = cube[0][i][2];
            cube[0][i][2] = cube[2][2][2-i];
            cube[2][2][2-i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[3][0][i];
            // cube[3][0][i] = tempSideFace[i];
            cube[3][0][i] = temp;
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
        /*
        char tempEdge = cube[2][0][1];
        cube[2][0][1] = cube[2][1][0];
        cube[2][1][0] = cube[2][2][1];
        cube[2][2][1] = cube[2][1][2];
        cube[2][1][2] = tempEdge;
        char tempCorner = cube[2][0][0];
        cube[2][0][0] = cube[2][2][0];
        cube[2][2][0] = cube[2][2][2];
        cube[2][2][2] = cube[2][0][2];
        cube[2][0][2] = tempCorner;
        */
        cube = mainFaceCW(cube, 2);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[0][0][i];
            temp = cube[0][0][i];
            cube[0][0][i] = cube[1][0][i];
            cube[1][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[5][0][i];
            // cube[5][0][i] = tempSideFace[i];
            cube[5][0][i] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] OCCW(char[][][] cube) {
        /*
        char tempEdge = cube[2][0][1];
        cube[2][0][1] = cube[2][1][2];
        cube[2][1][2] = cube[2][2][1];
        cube[2][2][1] = cube[2][1][0];
        cube[2][1][0] = tempEdge;
        char tempCorner = cube[2][0][0];
        cube[2][0][0] = cube[2][0][2];
        cube[2][0][2] = cube[2][2][2];
        cube[2][2][2] = cube[2][2][0];
        cube[2][2][0] = tempCorner;
        */
        cube = mainFaceCCW(cube, 2);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[0][0][i];
            temp = cube[0][0][i];
            cube[0][0][i] = cube[5][0][i];
            cube[5][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[1][0][i];
            // cube[1][0][i] = tempSideFace[i];
            cube[1][0][i] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] RCW(char[][][] cube) {
        /*
        char tempEdge = cube[3][0][1];
        cube[3][0][1] = cube[3][1][0];
        cube[3][1][0] = cube[3][2][1];
        cube[3][2][1] = cube[3][1][2];
        cube[3][1][2] = tempEdge;
        char tempCorner = cube[3][0][0];
        cube[3][0][0] = cube[3][2][0];
        cube[3][2][0] = cube[3][2][2];
        cube[3][2][2] = cube[3][0][2];
        cube[3][0][2] = tempCorner;
        */
        cube = mainFaceCW(cube, 3);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[0][2][i];
            temp = cube[0][2][i];
            cube[0][2][i] = cube[5][2][i];
            cube[5][2][i] = cube[4][2][i];
            cube[4][2][i] = cube[1][2][i];
            // cube[1][2][i] = tempSideFace[i];
            cube[1][2][i] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] RCCW(char[][][] cube) {
        /*
        char tempEdge = cube[3][0][1];
        cube[3][0][1] = cube[3][1][2];
        cube[3][1][2] = cube[3][2][1];
        cube[3][2][1] = cube[3][1][0];
        cube[3][1][0] = tempEdge;
        char tempCorner = cube[3][0][0];
        cube[3][0][0] = cube[3][0][2];
        cube[3][0][2] = cube[3][2][2];
        cube[3][2][2] = cube[3][2][0];
        cube[3][2][0] = tempCorner;
        */
        cube = mainFaceCCW(cube, 3);
        // char[] tempSideFace = new char[3];
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            // tempSideFace[i] = cube[0][0][i];
            temp = cube[0][2][i];
            cube[0][2][i] = cube[1][2][i];
            cube[1][2][i] = cube[4][2][i];
            cube[4][2][i] = cube[5][2][i];
            // cube[1][0][i] = tempSideFace[i];
            cube[5][2][i] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] YCW(char[][][] cube) {
        cube = mainFaceCW(cube, 4);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][2];
            cube[1][i][2] = cube[3][i][2];
            cube[3][i][2] = cube[5][2-i][0];
            cube[5][2-i][0] = cube[2][i][2];
            cube[2][i][2] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] YCCW(char[][][] cube) {
        cube = mainFaceCCW(cube, 4);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][2];
            cube[1][i][2] = cube[2][i][2];
            cube[2][i][2] = cube[5][2-i][0];
            cube[5][2-i][0] = cube[2][i][2];
            cube[2][i][2] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] GCW(char[][][] cube) {
        cube = mainFaceCW(cube, 5);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][0];
            cube[0][i][0] = cube[2][0][2-i];
            cube[2][0][2-i] = cube[4][2-i][2];
            cube[4][2-i][2] = cube[3][i][2];
            cube[3][i][2] = temp;
        }
        /*
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
        */
        return cube;
    }

    public static char[][][] GCCW(char[][][] cube) {
        cube = mainFaceCCW(cube, 5);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][0];
            cube[0][i][0] = cube[3][2-i][0];
            cube[3][2-i][0] = cube[4][2-i][2];
            cube[4][2-i][2] = cube[2][0][2-i];
            cube[2][0][2-1] = temp;
        }
        /*
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
        */
        return cube;
    }
}
