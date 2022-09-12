package rubikscubesolver.tests;

import org.junit.*;
import rubikscubesolver.CubeMoves;

public class CubeMovesTest {
    
    @Test
    public void testWCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'O', 'B', 'B'}, {'O', 'B', 'B'}, {'O', 'B', 'B'}}, {{'G', 'O', 'O'}, {'G', 'O', 'O'}, {'G', 'O', 'O'}},
                                                {{'B', 'R', 'R'}, {'B', 'R', 'R'}, {'B', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'R'}, {'G', 'G', 'R'}, {'G', 'G', 'R'}}};
        cube = CubeMoves.WCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testWCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'R', 'B', 'B'}, {'R', 'B', 'B'}, {'R', 'B', 'B'}}, {{'B', 'O', 'O'}, {'B', 'O', 'O'}, {'B', 'O', 'O'}},
                                                {{'G', 'R', 'R'}, {'G', 'R', 'R'}, {'G', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'O'}, {'G', 'G', 'O'}, {'G', 'G', 'O'}}};
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
    public void testBCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'a', 'b', 'y'}, {'d', '0', 'z'}, {'f', 'g', 'A'}}, {{'n', 'l', 'i'}, {'o', '1', 'j'}, {'p', 'm', 'k'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'h', 'e', 'c'}},
                                                {{'L', 'J', 'G'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'v', 'H', 'I'}, {'w', '4', 'K'}, {'x', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        cube = CubeMoves.BCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testBCCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'a', 'b', 'x'}, {'d', '0', 'w'}, {'f', 'g', 'v'}}, {{'k', 'm', 'p'}, {'j', '1', 'o'}, {'i', 'l', 'n'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'G', 'J', 'L'}},
                                                {{'c', 'e', 'h'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'A', 'H', 'I'}, {'z', '4', 'K'}, {'y', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        cube = CubeMoves.BCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testOCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'B', 'B', 'B'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'Y', 'Y', 'Y'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'G', 'G', 'G'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'W', 'W', 'W'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.OCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testOCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'G', 'G', 'G'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'W', 'W', 'W'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'B', 'B', 'B'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'Y', 'Y', 'Y'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.OCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testOCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'i', 'j', 'k'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'G', 'H', 'I'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'v', 't', 'q'}, {'w', '2', 'r'}, {'x', 'u', 's'}},
                                                {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'O', 'P', 'Q'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'a', 'b', 'c'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        cube = CubeMoves.OCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testOCCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'O', 'P', 'Q'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'a', 'b', 'c'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'s', 'u', 'x'}, {'r', '2', 'w'}, {'q', 't', 'v'}},
                                                {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'i', 'j', 'k'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'G', 'H', 'I'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        cube = CubeMoves.OCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testRCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'G', 'G', 'G'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'W', 'W', 'W'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'B', 'B', 'B'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'Y', 'Y', 'Y'}}};
        cube = CubeMoves.RCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testRCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'B', 'B', 'B'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'Y', 'Y', 'Y'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'G', 'G', 'G'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'W', 'W', 'W'}}};
        cube = CubeMoves.RCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testRCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'T', 'U', 'V'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'f', 'g', 'h'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                                {{'D', 'B', 'y'}, {'E', '3', 'z'}, {'F', 'C', 'A'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'n', 'o', 'p'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'L', 'M', 'N'}}};
        cube = CubeMoves.RCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testRCCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'n', 'o', 'p'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'L', 'M', 'N'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                                {{'A', 'C', 'F'}, {'z', '3', 'E'}, {'y', 'B', 'D'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'T', 'U', 'V'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'f', 'g', 'h'}}};
        cube = CubeMoves.RCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testYCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'R'}, {'B', 'B', 'R'}, {'B', 'B', 'R'}}, {{'O', 'O', 'B'}, {'O', 'O', 'B'}, {'O', 'O', 'B'}},
                                                {{'R', 'R', 'G'}, {'R', 'R', 'G'}, {'R', 'R', 'G'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'O', 'G', 'G'}, {'O', 'G', 'G'}, {'O', 'G', 'G'}}};
        cube = CubeMoves.YCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testYCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'O'}, {'B', 'B', 'O'}, {'B', 'B', 'O'}}, {{'O', 'O', 'G'}, {'O', 'O', 'G'}, {'O', 'O', 'G'}},
                                        {{'R', 'R', 'B'}, {'R', 'R', 'B'}, {'R', 'R', 'B'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'R', 'G', 'G'}, {'R', 'G', 'G'}, {'R', 'G', 'G'}}};
        cube = CubeMoves.YCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testYCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'A'}, {'l', '1', 'C'}, {'n', 'o', 'F'}}, {{'q', 'r', 'k'}, {'t', '2', 'm'}, {'v', 'w', 'p'}},
                                                {{'y', 'z', 'T'}, {'B', '3', 'R'}, {'D', 'E', 'O'}}, {{'L', 'J', 'G'}, {'M', '4', 'H'}, {'N', 'K', 'I'}}, {{'x', 'P', 'Q'}, {'u', '5', 'S'}, {'s', 'U', 'V'}}};
        cube = CubeMoves.YCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testYCCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 's'}, {'l', '1', 'u'}, {'n', 'o', 'x'}}, {{'q', 'r', 'T'}, {'t', '2', 'R'}, {'v', 'w', 'O'}},
                                                {{'y', 'z', 'k'}, {'B', '3', 'm'}, {'D', 'E', 'p'}}, {{'I', 'K', 'N'}, {'H', '4', 'M'}, {'G', 'J', 'L'}}, {{'F', 'P', 'Q'}, {'C', '5', 'S'}, {'A', 'U', 'V'}}};
        cube = CubeMoves.YCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testGCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'O', 'W', 'W'}, {'O', 'W', 'W'}, {'O', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'Y', 'Y', 'Y'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'W', 'W', 'W'}}, {{'Y', 'Y', 'R'}, {'Y', 'Y', 'R'}, {'Y', 'Y', 'R'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.GCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testGCCW_solved_cube () {
        char[][][] cube = new char[][][]{{{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                        {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}}, {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        char[][][] expectedCube = new char[][][]{{{'R', 'W', 'W'}, {'R', 'W', 'W'}, {'R', 'W', 'W'}}, {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, {{'W', 'W', 'W'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
                                                {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'Y', 'Y', 'Y'}}, {{'Y', 'Y', 'O'}, {'Y', 'Y', 'O'}, {'Y', 'Y', 'O'}}, {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}}};
        cube = CubeMoves.GCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testGCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'s', 'b', 'c'}, {'r', '0', 'e'}, {'q', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'I', 'K', 'N'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                                {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'a', 'd', 'f'}}, {{'G', 'H', 'F'}, {'J', '4', 'E'}, {'L', 'M', 'D'}}, {{'T', 'R', 'O'}, {'U', '5', 'P'}, {'V', 'S', 'Q'}}};
        cube = CubeMoves.GCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testGCCW_complex_cube () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                        {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'D', 'b', 'c'}, {'E', '0', 'e'}, {'F', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'f', 'd', 'a'}, {'t', '2', 'u'}, {'v', 'w', 'x'}},
                                                {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'N', 'K', 'I'}}, {{'G', 'H', 'q'}, {'J', '4', 'r'}, {'L', 'M', 's'}}, {{'Q', 'S', 'V'}, {'P', '5', 'U'}, {'O', 'R', 'T'}}};
        cube = CubeMoves.GCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }
}
