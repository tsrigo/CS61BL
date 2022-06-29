import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void test1() {
        // TODO: stub for first test
    }
    @Test
    public void testConstructor() {
        Measurement tep = new Measurement();
        assertEquals(0, tep.getFeet());
        assertEquals(0, tep.getInches());

        tep = new Measurement(15);
        assertEquals(15, tep.getFeet());
        assertEquals(0, tep.getInches());

        tep = new Measurement(99, 100);
        assertEquals(107, tep.getFeet());
        assertEquals(4, tep.getInches());

        Measurement tep1 = new Measurement(123, 321);
        assertEquals(149, tep1.getFeet());
        assertEquals(9, tep1.getInches());
        Measurement tep2 = new Measurement(321, 123);
        assertEquals(331, tep2.getFeet());
        assertEquals(3, tep2.getInches());
    }

    @Test
    public void plus() {
        Measurement tep1 = new Measurement(123, 321);
        Measurement tep2 = new Measurement(321, 123);
        tep1 = tep1.plus(tep2);
        assertEquals(481, tep1.getFeet());
        assertEquals(0, tep1.getInches());
    }

    @Test
    public void minus() {
        Measurement tep2 = new Measurement(123, 321);
        Measurement tep1 = new Measurement(321, 123);
        tep1 = tep1.minus(tep2);
        assertEquals(181, tep1.getFeet());
        assertEquals(6, tep1.getInches());
    }

    @Test
    public void multiple() {
        Measurement tep1 = new Measurement(123, 321);
        tep1 = tep1.multiple(7);
        assertEquals(1048, tep1.getFeet());
        assertEquals(3, tep1.getInches());
    }

    @Test
    public void testToString() {
        Measurement tep1 = new Measurement(123, 321);
        assertEquals("149\'9\"", tep1.toString());

        tep1 = new Measurement(0, 0);
        assertEquals("0\'0\"", tep1.toString());
    }

    // TODO: Add additional JUnit tests for Measurement.java here.

}