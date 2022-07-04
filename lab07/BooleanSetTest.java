import org.junit.Test;
import static org.junit.Assert.*;

public class BooleanSetTest {

    @Test
    public void testBasics() {
        BooleanSet aSet = new BooleanSet(100);
        assertEquals(0, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());

        for (int i = 0; i < 100; i += 2) {
            aSet.remove(i);
            assertFalse(aSet.contains(i));
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());
    }
    @Test
    public void testadd(){
        BooleanSet aSet = new BooleanSet(100);
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());
    }

    @Test
    public void testremove(){
        BooleanSet aSet = new BooleanSet(100);
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            aSet.remove(i);
            assertFalse(aSet.contains(i));
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());
    }

    @Test
    public void testcontains(){
        BooleanSet aSet = new BooleanSet(100);
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            assertTrue(aSet.contains(i));
        }
    }

    @Test
    public void testisEmpty(){
        BooleanSet aSet = new BooleanSet(100);
        assertTrue(aSet.isEmpty());
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertFalse(aSet.isEmpty());
        }
        assertEquals(50, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            aSet.remove(i);
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());
    }

    @Test
    public void testsize(){
        BooleanSet aSet = new BooleanSet(100);
        assertEquals(0, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertEquals(1 + i / 2, aSet.size());
        }
        assertEquals(50, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            aSet.remove(i);
            assertEquals(50 - i / 2 - 1, aSet.size());
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());
    }

    @Test
    public void testtoIntArray(){
        BooleanSet aSet = new BooleanSet(100);
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
        }
        int[] array = aSet.toIntArray();
        for (int i = 0; i < array.length / 2; i++) {
            assertTrue(array[2 * i] == 1);
            assertTrue(array[2 * i + 1] == 0);
        }
    }
}
