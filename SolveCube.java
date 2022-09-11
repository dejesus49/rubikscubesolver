package rubikscubesolver;

import java.util.*;

public class SolveCube {
    public static Queue<String> whiteCross(char[][][] cube) {
        Queue<String> solution = new LinkedList<String>();

        solution = whiteCorners(cube, solution);

        return solution;
    }

    public static Queue<String> whiteCorners(char[][][] cube, Queue<String> solution) {
        solution = secondLayer(cube, solution);

        return solution;
    }

    public static Queue<String> secondLayer(char[][][] cube, Queue<String> solution) {
        solution = yellowCross(cube, solution);

        return solution;
    }

    public static Queue<String> yellowCross(char[][][] cube, Queue<String> solution) {
        solution = yellowCorners(cube, solution);

        return solution;
    }

    public static Queue<String> yellowCorners(char[][][] cube, Queue<String> solution) {

        return solution;
    }
}
