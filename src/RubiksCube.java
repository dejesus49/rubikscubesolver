import java.util.*;

public class RubiksCube {

    public static void main(String[] args) {
        /* Open Scanner. */
        Scanner in = new Scanner(System.in);
        /* Initialize an Array for the Rubiks Cube. Each Rubiks Cube has 6 faces and each face has 3 rows and 3 columns. */
        char[][][] cube = new char[6][3][3];
        /* Print a greeting to the user. */
        PrintMessages.greeting();
        /* If the user doesn't type 'quit' to quit the program, proceed. */
        if (PrintMessages.printRules(in)) {
            /* Call the getCube function to get the user's Rubiks Cube orientation into the cube array. */
            cube = GetCube.getCube(in, cube);
            /* If the user doesn't type 'quit' to quit the program, proceed. */
            if (cube != null) {
                /* Iniitalize a Queue to keep track of all of the moves in the solution and in what order they were performed. */
                Queue<String>solution = new LinkedList<String>();                
                /* Call the whiteCross function to begin solving the cube. */
                solution = SolveCube.whiteCross(cube);
                /* Print out the solution */
                PrintMessages.printSolution(solution);
            }
        }
        /* Print a farwell to the user. */
        PrintMessages.farewell();
        /* Close Scanner. */
        in.close();
    }   
}