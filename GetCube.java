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

public class GetCube {

    static String COLORS = "ROYGBW";
    static char[][][] INSTRUCTIONCUBE = new char[][][]{{{'1','2','3'}, {'4','W','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','B','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','O','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','R','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','Y','5'}, {'6','7','8'}}, {{'1','2','3'}, {'4','G','5'}, {'6','7','8'}}};

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

    public static char[][][] getCube(Scanner in, char[][][] cube) {
        /* print out the defaultCube to give a visual of how the cube orientation should be input */
        PrintMessages.getCubeInstructions(INSTRUCTIONCUBE);
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
            System.out.print("Is this correct? Y/N: "); // need to check for invalid inputs
            if (in.nextLine().toUpperCase().charAt(0) == 'N') {
                getCube(in, cube);
            }
        } else {
            cube = null;// if user enters 'quit', assign null to cube to prevent main method from solving and to proceed to the farewell message
        }
        return cube;
    }
    /* 
    private static char[][][] getCube(char[][][] cube) {
        try {
            File cubeTest = new File("rubikscubesolver/cubetest.txt");
            Scanner in = new Scanner(cubeTest);
            try {
                BufferedImage cubeImage = ImageIO.read(new File("rubikscubesolver/cubeImage.png"));
                BufferedImage arrowImage = ImageIO.read(new File("rubikscubesolver/arrowImage.png"));
                Graphics g = cubeImage.getGraphics();
                g.drawImage(arrowImage, 10, 10, null);
                for (int i = 0; i < 6; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        for (int k = 0; k < 3; ++k){
                            char userInput = Character.toUpperCase(in.nextLine().charAt(0));
                            while (COLORS.indexOf(userInput) == -1) {
                                System.out.println("ERROR: Invalid color input");
                                System.out.print("ROYGBW: ");
                                userInput = in.nextLine().charAt(0);
                            }
                            cube[i][j][k] = userInput;
                        }
                    }
                }
                printCube(cube);
            }catch (IOException ex) {
                System.out.println("Error finding picture.");
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error finding file.");
        }   
    }
    */
}
