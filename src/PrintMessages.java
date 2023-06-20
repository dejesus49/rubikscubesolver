import java.util.*;
import java.util.concurrent.*;

public class PrintMessages {

    public static boolean printRules(Scanner in) {
        System.out.println("First, let's make sure you hold the cube right!");
        System.out.println("Hold the cube with the face with the white center facing you. This will make the face with the yellow center face away from you.");
        System.out.println("Maintaining this orientation, rotate the cube so that the face with the blue center faces right. This will make the face with the orange center face up, the green center face left, and the red center face down.");
        System.out.println("Great! You're ready to start!");
        String userInput;
        boolean proceed = true;
        do {
            System.out.print("Press enter to continue or type 'quit' to quit the program: ");
            userInput = in.nextLine().toUpperCase();
            if (userInput.equals("QUIT")) {
                proceed = false;
            }
        } while(!userInput.equals("") && !userInput.equals("QUIT"));
        return proceed;
    }

    /**
     * @requires 3 dimensional array of dimensions [6][3][3]
     * @param cube 
     * 3 dimensional array
     * Prints out a map of the rubiks cube
     */
    public static void printCubeMap(char[][][] cube) {
        System.out.println();
        for (int j = 0; j < 3; ++j) {
            System.out.print("       ");
            for (int k = 0; k < 3; ++k) {
                System.out.print(cube[2][j][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 3; ++k) {
                System.out.print(cube[0][j][k] + " ");
            }
            System.out.print(" ");
            for (int k = 0; k < 3; ++k) {
                System.out.print(cube[1][j][k]+ " ");
            }
            System.out.print(" ");
            for (int k = 0; k < 3; ++k) {
                System.out.print(cube[4][j][k]+ " ");
            }
            System.out.print(" ");
            for (int k = 0; k < 3; ++k) {
                System.out.print(cube[5][j][k]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int j = 0; j < 3; ++j) {
            System.out.print("       ");
            for (int k = 0; k < 3; ++k) {
                System.out.print(cube[3][j][k] + " ");
            }
            System.out.println();
        }
    }

    public static void getCubeInstructions() {
        try {
            System.out.println("\nLet's get your cube's orientation...");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted.");
        }
        char[][][] instructionCube = new char[][][]{{{'1','2','3'}, {'4','W','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','B','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','O','5'}, {'6','7','8'}},
                                                    {{'1','2','3'}, {'4','R','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','Y','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','G','5'}, {'6','7','8'}}};
        printCubeMap(instructionCube);
        System.out.println("\nEnter your cube's orientation with the first letter of each color (R O Y G B W) in the order described.");
        System.out.println("The order of faces you will input is as follows: White, Blue, Orange, Red, Yellow, Green.");
        System.out.println("For each face, enter each square's color in the following order as shown in the map above: 1234X5678 where X is the first letter of the center square's color. Separate each face's orientation by a space."); 
        System.out.println("Example input:\nRRWOWYBWR BGGBBYYWB WRGGOROYO GOYBROYOW WWORYWOGB RYRBGGGBY");
        System.out.println("Please enter your cube orientation or type 'quit' to quit the program:");
    }

    public static void printSolution(Queue<String>Solution) {
        int moves = Solution.size();
        for (int i = 0; i < moves; ++i) {
            String shift = Solution.remove();
            System.out.print(shift + " ");
            Solution.add(shift);
        }
    }

    public static void greeting() {
        Random rand = new Random();
        String[] greetingMessages = new String[]{"Greetings!", "Hello!", "Aloha!", "Sup!", "Why hello there!", "Salutations!"};
        System.out.println("\n\n" + greetingMessages[rand.nextInt(greetingMessages.length)] + " Welcome to THE Rubiks Cube Solver!\n");
    }

    public static void farewell() {
        Random rand = new Random();
        String[] farewellMessages = new String[]{"Farewell!", "Goodbye!", "Take care!", "Peace out!", "Fare thee well!", "Have a good one!", "Adios!"};
        System.out.println(farewellMessages[rand.nextInt(farewellMessages.length)]);
    }
    
}
