package main;
public abstract class CubeMoves {

    private static char[][][] mainFaceCW(char[][][] cube, int mainFace) {
        /* Switch the orientation of the edge pieces of the main face. */
        char tempEdge = cube[mainFace][0][1];
        cube[mainFace][0][1] = cube[mainFace][1][0];
        cube[mainFace][1][0] = cube[mainFace][2][1];
        cube[mainFace][2][1] = cube[mainFace][1][2];
        cube[mainFace][1][2] = tempEdge;
        /* Switch the orientation of the corner pieces of the main face. */
        char tempCorner = cube[mainFace][0][0];
        cube[mainFace][0][0] = cube[mainFace][2][0];
        cube[mainFace][2][0] = cube[mainFace][2][2];
        cube[mainFace][2][2] = cube[mainFace][0][2];
        cube[mainFace][0][2] = tempCorner;

        return cube;
    }

    private static char[][][] mainFaceCCW(char[][][] cube, int mainFace) {
        /* Switch the orientation of the edge pieces of the main face. */
        char tempEdge = cube[mainFace][0][1];
        cube[mainFace][0][1] = cube[mainFace][1][2];
        cube[mainFace][1][2] = cube[mainFace][2][1];
        cube[mainFace][2][1] = cube[mainFace][1][0];
        cube[mainFace][1][0] = tempEdge;
        /* Switch the orientation of the corner pieces of the main face. */
        char tempCorner = cube[mainFace][0][0];
        cube[mainFace][0][0] = cube[mainFace][0][2];
        cube[mainFace][0][2] = cube[mainFace][2][2];
        cube[mainFace][2][2] = cube[mainFace][2][0];
        cube[mainFace][2][0] = tempCorner;

        return cube;
    }

    protected static char[][][] WCW(char[][][] cube) {
        /* Call the function mainFaceCW to change the orientation of the white face. */
        cube = mainFaceCW(cube, 0);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][0];
            cube[1][i][0] = cube[2][i][0];
            cube[2][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[3][i][0];
            cube[3][i][0] = temp;
        }

        return cube;
    }

    protected static char[][][] WCCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the white face. */
        cube = mainFaceCCW(cube, 0);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][0];
            cube[1][i][0] = cube[3][i][0];
            cube[3][i][0] = cube[5][2-i][2];
            cube[5][2-i][2] = cube[2][i][0];
            cube[2][i][0] = temp;
        }

        return cube;
    }

    protected static char[][][] BCW(char[][][] cube) {
        /* Call the function mainFaceCW to change the orientation of the blue face. */
        cube = mainFaceCW(cube, 1);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][2];
            cube[0][i][2] = cube[3][0][i];
            cube[3][0][i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[2][2][2-i];
            cube[2][2][2-i] = temp;
        }

        return cube;
    }

    protected static char[][][] BCCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the blue face. */
        cube = mainFaceCCW(cube, 1);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][2];
            cube[0][i][2] = cube[2][2][2-i];
            cube[2][2][2-i] = cube[4][2-i][0];
            cube[4][2-i][0] = cube[3][0][i];
            cube[3][0][i] = temp;
        }

        return cube;
    }

    protected static char[][][] OCW(char[][][] cube) {
        /* Call the function mainFaceCW to change the orientation of the orange face. */
        cube = mainFaceCW(cube, 2);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][0][i];
            cube[0][0][i] = cube[1][0][i];
            cube[1][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[5][0][i];
            cube[5][0][i] = temp;
        }

        return cube;
    }

    protected static char[][][] OCCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the orange face. */
        cube = mainFaceCCW(cube, 2);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][0][i];
            cube[0][0][i] = cube[5][0][i];
            cube[5][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[1][0][i];
            cube[1][0][i] = temp;
        }

        return cube;
    }

    protected static char[][][] RCW(char[][][] cube) {
        /* Call the function mainFaceCW to change the orientation of the red face. */
        cube = mainFaceCW(cube, 3);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][2][i];
            cube[0][2][i] = cube[5][2][i];
            cube[5][2][i] = cube[4][2][i];
            cube[4][2][i] = cube[1][2][i];
            cube[1][2][i] = temp;
        }

        return cube;
    }

    protected static char[][][] RCCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the red face. */
        cube = mainFaceCCW(cube, 3);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][2][i];
            cube[0][2][i] = cube[1][2][i];
            cube[1][2][i] = cube[4][2][i];
            cube[4][2][i] = cube[5][2][i];
            cube[5][2][i] = temp;
        }

        return cube;
    }

    protected static char[][][] YCW(char[][][] cube) {
        /* Call the function mainFaceCW to change the orientation of the yellow face. */
        cube = mainFaceCW(cube, 4);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][2];
            cube[1][i][2] = cube[3][i][2];
            cube[3][i][2] = cube[5][2-i][0];
            cube[5][2-i][0] = cube[2][i][2];
            cube[2][i][2] = temp;
        }

        return cube;
    }

    protected static char[][][] YCCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the yellow face. */
        cube = mainFaceCCW(cube, 4);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[1][i][2];
            cube[1][i][2] = cube[2][i][2];
            cube[2][i][2] = cube[5][2-i][0];
            cube[5][2-i][0] = cube[3][i][2];
            cube[3][i][2] = temp;
        }
        
        return cube;
    }

    protected static char[][][] GCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the green face. */
        cube = mainFaceCW(cube, 5);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][0];
            cube[0][i][0] = cube[2][0][2-i];
            cube[2][0][2-i] = cube[4][2-i][2];
            cube[4][2-i][2] = cube[3][2][i];
            cube[3][2][i] = temp;
        }
        
        return cube;
    }

    protected static char[][][] GCCW(char[][][] cube) {
        /* Call the function mainFaceCCW to change the orientation of the green face. */
        cube = mainFaceCCW(cube, 5);
        char temp = ' ';
        /* For loop changes the orientation of the side faces affected by the rotation. */
        for (int i = 0; i < 3; ++i) {
            temp = cube[0][i][0];
            cube[0][i][0] = cube[3][2][i];
            cube[3][2][i] = cube[4][2-i][2];
            cube[4][2-i][2] = cube[2][0][2-i];
            cube[2][0][2-i] = temp;
        }
        
        return cube;
    }
}
