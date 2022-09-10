package rubikscubesolver;
import java.util.*;
import java.util.concurrent.*;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.awt.Graphics;
// import java.awt.image.BufferedImage;
// import javax.swing.JPanel;
// import javax.imageio.ImageIO;

public class RubiksCube /* extends JPanel */ {

    static String COLORS = "ROYGBW";
    static char[][][] INSTRUCTIONCUBE = new char[][][]{{{'1','2','3'}, {'4','W','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','B','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','O','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','R','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','Y','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','G','5'}, {'6','7','8'}}};
    static char[][][] SOLVEDCUBE = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}}, {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
    static char[][][] TESTCUBE = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}}, {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};


    public static boolean printRules(Scanner in) {
        System.out.println("First, let's make sure you hold the cube right!");
        System.out.println("Hold the cube with the face with the white center facing you.");
        System.out.println("This will make the face with the yellow center face away from you.");
        System.out.println("Maintaining this orientation, rotate the cube so that the face with the blue center faces right, the face with the orange center faces up, the face with the green center faces left, and the face with the red center faces down.");
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

    public static boolean inputCheck(String userInput) {
        boolean check = true;
        if (userInput.length() < 59) {
            check = false;
        } else if (userInput.charAt(4) != 'W' || userInput.charAt(14) != 'B' || userInput.charAt(24) != 'Y' || userInput.charAt(34) != 'O' || userInput.charAt(44) != 'R' || userInput.charAt(54) != 'G') {
            check = false;
        } else if (userInput.charAt(9) != ' ' || userInput.charAt(19) != ' ' || userInput.charAt(29) != ' ' || userInput.charAt(39) != ' ' || userInput.charAt(49) != ' ') {
            check = false;
        } else {
            Map <Character, Integer> colorCount = new HashMap<>();
            for (int i = 0; i < userInput.length(); ++i) {
                if((COLORS.indexOf(userInput.charAt(i)) == -1 && userInput.charAt(i) != ' ')) {
                    check = false;
                    break;
                } else if (userInput.charAt(i) != ' ') {
                    colorCount.merge(userInput.charAt(i), 1, Integer::sum);
                }
            }
            if (colorCount.size() == 6) {
                for (int i = 0; i < 6; ++i) {
                    if (colorCount.remove(COLORS.charAt(i)) != 9) {
                        check = false;
                    }
                }
            } else {
                check = false;
            }
        }
        // need to check if cube is a possibility by checking each individual pieces
        return check;
    }

    private static void getCubeInstructions() {
        try {
            System.out.println("\nNow let's get your cube's orientation...");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted.");
        }
        printCubeMap(INSTRUCTIONCUBE);
        System.out.println("\nEnter your cube's orientation with the first letter of each color (R O Y G B W) in the order described.");
        System.out.println("The order of faces you will input is as follows: White, Blue, Yellow, Orange, Red, Green.");
        System.out.println("For each face, enter each square's color in the following order as shown in the map above: 1234X5678 where X is the first letter of the center square's color. Separate each face's orientation by a space."); 
        System.out.println("Example input:\nRRWOWYBWR BGGBBYYWB WWORYWOGB WRGGOROYO GOYBROYOW RYRBGGGBY");
        System.out.println("Please enter your cube orientation or type 'quit' to quit the program:");
    }

    public static char[][][] getCube(Scanner in, char[][][] cube) {
        /* print out the defaultCube to give a visual of how the cube orientation should be input */
        getCubeInstructions();
        String userInput = in.nextLine().toUpperCase();
        if (!userInput.equals("QUIT")) {
            if (!inputCheck(userInput)) {
                System.out.println("Invalid input. Restarting...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println("Sleep interrupted.");
                }
                getCube(in, cube);
            }
            int l = 0;
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        if (userInput.charAt(l) != ' ') {
                            cube[i][j][k] = userInput.charAt(l);
                        } else {
                            ++l;
                            cube[i][j][k] = userInput.charAt(l);
                        }
                        ++l;
                    }
                }
            }
            printCubeMap(cube);
            System.out.print("Is this correct? Y/N: "); // need to check for invalid inputs
            if (in.nextLine().toUpperCase().charAt(0) == 'N') {
                getCube(in, cube);
            }
        } else {
            cube = INSTRUCTIONCUBE;// if user enters 'quit', assign defaultCube to cube to prevent main method from solving and to proceed to the farewell message
        }
        return cube;
    } 

    /* 
    // private static char[][][] getCube(char[][][] cube) {
    //     try {
    //         File cubeTest = new File("rubikscubesolver/cubetest.txt");
    //         Scanner in = new Scanner(cubeTest);
    //         try {
    //             BufferedImage cubeImage = ImageIO.read(new File("rubikscubesolver/cubeImage.png"));
    //             BufferedImage arrowImage = ImageIO.read(new File("rubikscubesolver/arrowImage.png"));
    //             Graphics g = cubeImage.getGraphics();
    //             g.drawImage(arrowImage, 10, 10, null);
    //             for (int i = 0; i < 6; ++i) {
    //                 for (int j = 0; j < 3; ++j) {
    //                     for (int k = 0; k < 3; ++k){
    //                         char userInput = Character.toUpperCase(in.nextLine().charAt(0));
    //                         while (COLORS.indexOf(userInput) == -1) {
    //                             System.out.println("ERROR: Invalid color input");
    //                             System.out.print("ROYGBW: ");
    //                             userInput = in.nextLine().charAt(0);
    //                         }
    //                         cube[i][j][k] = userInput;
    //                     }
    //                 }
    //             }
    //             printCube(cube);
    //         }catch (IOException ex) {
    //             System.out.println("Error finding picture.");
    //         }
    //         in.close();
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Error finding file.");
    //     }   
    // }
    */

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

    public static void printSolution(Queue<String>Solution) {
        int moves = Solution.size();
        for (int i = 0; i < moves; ++i) {
            String shift = Solution.remove();
            System.out.print(shift + " ");
            Solution.add(shift);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        String[] greetingMessages = new String[]{"Greetings!", "Hello!", "Aloha!", "Sup!", "Why hello there!", "Salutations!"};
        System.out.println("\n\n" + greetingMessages[rand.nextInt(greetingMessages.length)] + " Welcome to THE Rubiks Cube Solver!\n");
        char[][][] cube = new char[6][3][3];
        
        if (printRules(in)) {
            getCube(in, cube);
            if (!Arrays.equals(cube, INSTRUCTIONCUBE)) {
                Queue<String>Solution = new LinkedList<String>();
                int x = 1;
                if (x == 1) {
                    printCubeMap(TESTCUBE);
                    // cube = CubeMoves.WCW(TESTCUBE);
                    // Solution.add("W");
                    // cube = CubeMoves.WCCW(cube);
                    // Solution.add("W!");
                    // cube = CubeMoves.BCW(TESTCUBE);
                    // Solution.add("B");
                    // cube = CubeMoves.BCCW(TESTCUBE);
                    // Solution.add("B!");
                    // cube = CubeMoves.OCW(TESTCUBE);
                    // Solution.add("O");
                    // cube = CubeMoves.OCCW(TESTCUBE);
                    // Solution.add("O!");
                    // cube = CubeMoves.RCW(TESTCUBE);
                    // Solution.add("R");
                    // cube = CubeMoves.RCCW(TESTCUBE);
                    // Solution.add("R!");
                    // cube = CubeMoves.YCW(TESTCUBE);
                    // Solution.add("Y");
                    // cube = CubeMoves.YCCW(TESTCUBE);
                    // Solution.add("Y!");
                    // cube = CubeMoves.GCW(TESTCUBE);
                    // Solution.add("G");
                    // cube = CubeMoves.GCCW(TESTCUBE);
                    // Solution.add("G!");
                    printSolution(Solution);
                    printCubeMap(cube);
                }
            // whiteCross();
            // whiteCorners();

            // secondLayer();

            // yellowCross();
            // yellowCorners();

            // cleanQueue();

            // printSolution();

            }
        }
        String[] farewellMessages = new String[]{"Farewell!", "Goodbye!", "Take care!", "Peace out!", "Fare thee well!", "Have a good one!", "Adios!"};
        System.out.println(farewellMessages[rand.nextInt(farewellMessages.length)]);
        in.close();
    }   
}