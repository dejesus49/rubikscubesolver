package rubikscubesolver.tests;

import org.junit.*;

import rubikscubesolver.CubeMoves;
// import rubikscubesolver.PrintMessages;

public class CubeMovesTest {
    
    @Test
    public void testWCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.WCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testWCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.WCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testWCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'f', 'd', 'a'}, {'g', '0', 'b'}, {'h', 'e', 'c'}}, {{'q', 'j', 'k'}, {'t', '1', 'm'}, {'v', 'o', 'p'}}, {{'V', 'r', 's'}, {'S', '2', 'u'}, {'Q', 'w', 'x'}},
                                                {{'i', 'z', 'A'}, {'l', '3', 'C'}, {'n', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'D'}, {'R', '5', 'B'}, {'T', 'U', 'y'}}};
        cube = CubeMoves.WCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testWCCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'c', 'e', 'h'}, {'b', '0', 'g'}, {'a', 'd', 'f'}}, {{'y', 'j', 'k'}, {'B', '1', 'm'}, {'D', 'o', 'p'}}, {{'i', 'r', 's'}, {'l', '2', 'u'}, {'n', 'w', 'x'}},
                                                {{'V', 'z', 'A'}, {'S', '3', 'C'}, {'Q', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'v'}, {'R', '5', 't'}, {'T', 'U', 'q'}}};
        cube = CubeMoves.WCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testBCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'R'}, {'W', 'W', 'R'}, {'W', 'W', 'R'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'W', 'W', 'W'}},
                                        {{'Y', 'Y', 'Y'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'O', 'Y', 'Y'}, {'O', 'Y', 'Y'}, {'O', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.BCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testBCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'O'}, {'W', 'W', 'O'}, {'W', 'W', 'O'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'Y', 'Y', 'Y'}},
                                        {{'W', 'W', 'W'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'R', 'Y', 'Y'}, {'R', 'Y', 'Y'}, {'R', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.BCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testOCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.OCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testOCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.OCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testRCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.RCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testRCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.RCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testYCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.YCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testYCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.YCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testGCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.GCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testGCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.GCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }
}
