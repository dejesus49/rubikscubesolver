package rubikscubesolver;
import java.util.*;

public class RubiksCube /* extends JPanel */ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintMessages.greeting();
        char[][][] cube = new char[6][3][3];
        
        if (PrintMessages.printRules(in)) {
            cube = GetCube.getCube(in, cube);
            if (cube != null) {
                Queue<String>solution = new LinkedList<String>();                
                
                solution = SolveCube.whiteCross(cube);
                PrintMessages.printSolution(solution);
            }
        }
        PrintMessages.farewell();
        in.close();
    }   
}