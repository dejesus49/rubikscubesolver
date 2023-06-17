package rubikscubesolver.src;

import java.util.*;
import java.util.concurrent.*;

public class GetCube {

    public static boolean inputCheck(String userInput) {
        String colors = "ROYGBW";
        boolean check = true;
        // should print feedback as to how input is invalid.
        if (userInput.length() != 59) {
            /* The length of the input for the cube orientation should be 59 because there should be 54 letters and 5 spaces separating every 9 letters.
             * If this is not the length of the input, the input is invalid, so make check false to return false.
             */
            check = false;
        } else if (userInput.charAt(4) != 'W' || userInput.charAt(14) != 'B' || userInput.charAt(24) != 'O' || userInput.charAt(34) != 'R' || userInput.charAt(44) != 'Y' || userInput.charAt(54) != 'G') {
            /* The 4th, 14th, 24th, 34th, 44th, and 54th indexes need to be the letters W,B,O,R,Y,G respectively.
             * If those indexes do not hold those letters, the input is invalid, so make check false to return false.
             */
            check = false;
        } else if (userInput.charAt(9) != ' ' || userInput.charAt(19) != ' ' || userInput.charAt(29) != ' ' || userInput.charAt(39) != ' ' || userInput.charAt(49) != ' ') {
            /* The 9th, 19th, 29th, 39th, and 49th indexes need to be the character ' '.
             * If those indexes do not hold ' ', the input is invalid, so make check false to return false.
             */
            check = false;
        } else {
            Map <Character, Integer> colorCount = new HashMap<>();
            for (int i = 0; i < userInput.length(); ++i) {
                if((colors.indexOf(userInput.charAt(i)) == -1 && userInput.charAt(i) != ' ')) {
                    check = false;
                    break;
                } else if (userInput.charAt(i) != ' ') {
                    colorCount.merge(userInput.charAt(i), 1, Integer::sum);
                }
            }
            if (colorCount.size() == 6) {
                for (int i = 0; i < 6; ++i) {
                    if (colorCount.remove(colors.charAt(i)) != 9) {
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

    public static char[][][] getCube(Scanner in, char[][][] cube) {
        PrintMessages.getCubeInstructions();
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
            PrintMessages.printCubeMap(cube);
            System.out.print("\nIs this correct? Y/N: "); // need to check for invalid inputs
            if (in.nextLine().toUpperCase().charAt(0) == 'N') {
                getCube(in, cube);
            }
        } else {
            /* If the user enters 'quit', assign null to cube to prevent the main method from solving and to proceed to the farewell message. */
            cube = null;
        }
        return cube;
    }
}
