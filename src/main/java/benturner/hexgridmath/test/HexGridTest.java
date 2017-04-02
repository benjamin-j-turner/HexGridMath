package benturner.hexgridmath.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import benturner.hexgridmath.Hex;

/**
 * Created by bturner on 4/2/2017.
 */

public class HexGridTest {
    @Test
    public void constructorTest() {
        Hex h = new Hex(0, 1, -1);
        assertEquals("3-param constructor - Q coordinate incorrect", 0, h.getQ());
        assertEquals("3-param constructor - R coordinate incorrect", 1, h.getR());
        assertEquals("3-param constructor - S coordinate incorrect", -1, h.getS());

        Hex h2 = new Hex(0, 1);
        assertEquals("2-param constructor - Q coordinate incorrect", 0, h.getQ());
        assertEquals("2-param constructor - R coordinate incorrect", 1, h.getR());
        assertEquals("2-param constructor - S coordinate incorrect", -1, h.getS());

        //TODO: test invalid arguments
    }
}
