import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {
    @Test
    public void testConstructor() {
        Counter c = new Counter();
        assertEquals(0, c.value());
    }
    @Test
    public void increment() {
        Counter c = new Counter();
        c.increment();
        assertEquals(1, c.value());
        c.increment();
        assertEquals(2, c.value());
    }

    @Test
    public void reset() {
        Counter c = new Counter();
        c.increment();
        c.reset();
        assertEquals(0, c.value());
    }
}