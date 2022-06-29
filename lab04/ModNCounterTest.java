import org.junit.Test;

import static org.junit.Assert.*;

public class ModNCounterTest {
    @Test
    public void testConstructor() {
        ModNCounter c = new ModNCounter(5);
        assertEquals(0, c.value());
        assertEquals(5, c.getMyN());

        c = new ModNCounter(50);
        assertEquals(0, c.value());
        assertEquals(50, c.getMyN());

        c = new ModNCounter(999);
        assertEquals(0, c.value());
        assertEquals(999, c.getMyN());
    }
    @Test
    public void increment() {
        ModNCounter c = new ModNCounter(4);
        c.increment();
        assertEquals(1, c.value());
        c.increment();
        assertEquals(2, c.value());
        c.increment();
        assertEquals(3, c.value());
        c.increment();
        assertEquals(0, c.value());
        c.increment();
        assertEquals(1, c.value());
        c.increment();
        assertEquals(2, c.value());
        c.increment();
        assertEquals(3, c.value());
        c.increment();
        assertEquals(0, c.value());

    }

    @Test
    public void reset() {
        ModNCounter c = new ModNCounter(4);
        c.increment();
        c.reset();
        assertEquals(0, c.value());
    }
}