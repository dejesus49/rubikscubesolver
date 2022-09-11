package rubikscubesolver;


public class CubeMoves {

    private static char[][][] mainFaceCW(char[][][] cube, int mainFace) {
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
        cube = mainFaceCW(cube, 0);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][0];
            cube[1][i][0] = cube[2][i][0];
            cube[2][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[3][i][0];
            cube[3][i][0] = temp;
        }

        return cube;
    }

    public static char[][][] WCCW(char[][][] cube) {
        cube = mainFaceCCW(cube, 0);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][0];
            cube[1][i][0] = cube[3][i][0];
            cube[3][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[2][i][0];
            cube[2][i][0] = temp;
        }

        return cube;
    }

    public static char[][][] BCW(char[][][] cube) {
        cube = mainFaceCW(cube, 1);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][2];
            cube[0][i][2] = cube[3][0][i];
            cube[3][0][i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[2][2][2-i];
            cube[2][2][2-i] = temp;
        }

        return cube;
    }

    public static char[][][] BCCW(char[][][] cube) {
        cube = mainFaceCCW(cube, 1);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][2];
            cube[0][i][2] = cube[2][2][2-i];
            cube[2][2][2-i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[3][0][i];
            cube[3][0][i] = temp;
        }

        return cube;
    }

    public static char[][][] OCW(char[][][] cube) {
        cube = mainFaceCW(cube, 2);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][0][i];
            cube[0][0][i] = cube[1][0][i];
            cube[1][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[5][0][i];
            cube[5][0][i] = temp;
        }

        return cube;
    }

    public static char[][][] OCCW(char[][][] cube) {
        cube = mainFaceCCW(cube, 2);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][0][i];
            cube[0][0][i] = cube[5][0][i];
            cube[5][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[1][0][i];
            cube[1][0][i] = temp;
        }
        return cube;
    }

    public static char[][][] RCW(char[][][] cube) {
        cube = mainFaceCW(cube, 3);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][2][i];
            cube[0][2][i] = cube[5][2][i];
            cube[5][2][i] = cube[4][2][i];
            cube[4][2][i] = cube[1][2][i];
            cube[1][2][i] = temp;
        }

        return cube;
    }

    public static char[][][] RCCW(char[][][] cube) {
        cube = mainFaceCCW(cube, 3);
        char temp = ' ';

        for (int i = 0; i < 3; ++i) {
            temp = cube[0][2][i];
            cube[0][2][i] = cube[1][2][i];
            cube[1][2][i] = cube[4][2][i];
            cube[4][2][i] = cube[5][2][i];
            cube[5][2][i] = temp;
        }

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
        
        return cube;
    }
}
