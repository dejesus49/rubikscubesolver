package rubikscubesolver.tests;

import org.junit.*;

import rubikscubesolver.CubeMoves;

public class CubeMovesTest {

    @Test
    public void testWCW () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}}, {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'f', 'd', 'a'}, {'g', '0', 'b'}, {'h', 'e', 'c'}}, {{'q', 'j', 'k'}, {'t', '1', 'm'}, {'v', 'o', 'p'}}, {{'V', 'r', 's'}, {'S', '2', 'u'}, {'Q', 'w', 'x'}}, {{'i', 'z', 'A'}, {'l', '3', 'C'}, {'n', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'D'}, {'R', '5', 'B'}, {'T', 'U', 'y'}}};
        cube = CubeMoves.WCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }

    @Test
    public void testWCCW () {
        char[][][] cube = new char[][][]{{{'a', 'b', 'c'}, {'d', '0', 'e'}, {'f', 'g', 'h'}}, {{'i', 'j', 'k'}, {'l', '1', 'm'}, {'n', 'o', 'p'}}, {{'q', 'r', 's'}, {'t', '2', 'u'}, {'v', 'w', 'x'}}, {{'y', 'z', 'A'}, {'B', '3', 'C'}, {'D', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'Q'}, {'R', '5', 'S'}, {'T', 'U', 'V'}}};
        char[][][] expectedCube = new char[][][]{{{'c', 'e', 'h'}, {'b', '0', 'g'}, {'a', 'd', 'f'}}, {{'y', 'j', 'k'}, {'B', '1', 'm'}, {'D', 'o', 'p'}}, {{'i', 'r', 's'}, {'l', '2', 'u'}, {'n', 'w', 'x'}}, {{'V', 'z', 'A'}, {'S', '3', 'C'}, {'Q', 'E', 'F'}}, {{'G', 'H', 'I'}, {'J', '4', 'K'}, {'L', 'M', 'N'}}, {{'O', 'P', 'v'}, {'R', '5', 't'}, {'T', 'U', 'q'}}};
        cube = CubeMoves.WCCW(cube);
        Assert.assertArrayEquals(expectedCube, cube);
    }
    
}
