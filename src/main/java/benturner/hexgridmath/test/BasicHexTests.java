package benturner.hexgridmath.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import benturner.hexgridmath.Hex;

/**
 * Created by bturner on 4/2/2017.
 */

public class BasicHexTests {
    @Test
    public void constructorTest() {
        Hex h = new Hex(0, 1, -1);
        assertEquals("3-param constructor - Q coordinate incorrect", 0, h.getQ());
        assertEquals("3-param constructor - R coordinate incorrect", 1, h.getR());
        assertEquals("3-param constructor - S coordinate incorrect", -1, h.getS());

        //TODO: test invalid arguments
    }

    @Test
    public void constructorTest2() {
        Hex h = new Hex(0, 1);
        assertEquals("2-param constructor - Q coordinate incorrect", 0, h.getQ());
        assertEquals("2-param constructor - R coordinate incorrect", 1, h.getR());
        assertEquals("2-param constructor - S coordinate incorrect", -1, h.getS());
    }

    @Test
    public void additionTest() {
        Hex h1 = new Hex(1, 2, -3);
        Hex h2 = new Hex(-1, 0, 1);

        Hex addResult = h1.addHex(h2);
        assertEquals("Hex addition incorrect", addResult, new Hex(0, 2, -2));
    }

    @Test
    public void subtractionTest() {
        Hex h1 = new Hex(1, 2, -3);
        Hex h2 = new Hex(-1, 0, 1);

        Hex subtractResult = h1.subtractHex(h2);
        assertEquals("Hex subtraction incorrect", subtractResult, new Hex(2, 2, -4));
    }

    @Test
    public void multiplicationTest() {
        Hex h1 = new Hex(1, 2, -3);
        Hex h2 = new Hex(-1, 0, 1);

        Hex multiplyResult = h1.hexMultiply(3);
        assertEquals("Hex addition incorrect", multiplyResult, new Hex(3, 6, -9));
    }
}
