import org.junit.Test;
import static org.junit.Assert.*;

public class ListSetTest {

    @Test
    public void testBasics() {
        ListSet aSet = new ListSet();
        assertEquals(0, aSet.size());
        for (int i = -50; i < 50; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());
        for (int i = -50; i < 50; i += 2) {
            aSet.remove(i);
            assertFalse(aSet.contains(i));
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());

        for (int i = -50; i < 50; i += 2) {
            aSet.add(i);
        }
        assertEquals(50, aSet.size());
        for (int i = -50; i < 50; i += 2) {
            aSet.remove(i);
        }
        assertTrue(aSet.isEmpty()); 
        assertEquals(0, aSet.size());
        
    }

    @Test
    public void testadd() {
        ListSet aSet = new ListSet();
        aSet.add(1);
        assertEquals(1, aSet.size());
        aSet.add(1);
        assertEquals(1, aSet.size());
        aSet.add(2);
        assertEquals(2, aSet.size());
        aSet.add(3);
        assertEquals(3, aSet.size());
        aSet.add(4);
        assertEquals(4, aSet.size());
        aSet.add(5);
        assertEquals(5, aSet.size());
        aSet.add(6);
        assertEquals(6, aSet.size());
        aSet.add(7);
        assertEquals(7, aSet.size());
        aSet.add(8);
        assertEquals(8, aSet.size());
        aSet.add(8);
        assertEquals(8, aSet.size());
    }

    @Test
    public void testremove() { 
        ListSet aSet = new ListSet();
        aSet.add(1);
        aSet.add(2);
        aSet.add(3);
        aSet.add(4);
        aSet.add(5);
        aSet.add(6);
        aSet.add(7);
        aSet.add(8);
        aSet.remove(1);
        assertEquals(7, aSet.size());
        aSet.remove(2);
        assertEquals(6, aSet.size());
        aSet.remove(3);
        assertEquals(5, aSet.size());
        aSet.remove(4);
        assertEquals(4, aSet.size());
        aSet.remove(5);
        assertEquals(3, aSet.size());
        aSet.remove(6);
        assertEquals(2, aSet.size());
        aSet.remove(7);
        assertEquals(1, aSet.size());
        aSet.remove(8);
        assertEquals(0, aSet.size());    
    }

    @Test
    public void testcontains(){
        ListSet aSet = new ListSet();
        aSet.add(1);
        aSet.add(2);
        aSet.add(3);
        aSet.add(4);
        aSet.add(5);
        aSet.add(6);
        aSet.add(7);
        aSet.add(8);
        assertTrue(aSet.contains(1));
        assertTrue(aSet.contains(2));
        assertTrue(aSet.contains(3));
        assertTrue(aSet.contains(4));
        assertTrue(aSet.contains(5));
        assertTrue(aSet.contains(6));
        assertTrue(aSet.contains(7));
        assertTrue(aSet.contains(8));
        assertFalse(aSet.contains(9));
        assertFalse(aSet.contains(10));
        assertFalse(aSet.contains(11));
        assertFalse(aSet.contains(12));
        assertFalse(aSet.contains(13));
        assertFalse(aSet.contains(14));
        assertFalse(aSet.contains(15));
        assertFalse(aSet.contains(16));
        assertFalse(aSet.contains(17));
        assertFalse(aSet.contains(18));
        assertFalse(aSet.contains(19));
        assertFalse(aSet.contains(20));
        assertFalse(aSet.contains(21));
        assertFalse(aSet.contains(22));
        assertFalse(aSet.contains(23));
        assertFalse(aSet.contains(24));
        assertFalse(aSet.contains(25));
        assertFalse(aSet.contains(26));
        assertFalse(aSet.contains(27));
        assertFalse(aSet.contains(28));
        assertFalse(aSet.contains(29));
        assertFalse(aSet.contains(30));
        assertFalse(aSet.contains(31));
        assertFalse(aSet.contains(32));
    }

    @Test
    public void testisEmpty(){
        ListSet aSet = new ListSet();
        assertTrue(aSet.isEmpty());
        aSet.add(1);
        assertFalse(aSet.isEmpty());
        aSet.remove(1);
        assertTrue(aSet.isEmpty());
    }

    @Test
    public void testsize(){
        ListSet aSet = new ListSet();
        assertEquals(0, aSet.size());
        aSet.add(1);
        assertEquals(1, aSet.size());
        aSet.add(2);
        assertEquals(2, aSet.size());
        aSet.add(3);
        assertEquals(3, aSet.size());
        aSet.add(4);
        assertEquals(4, aSet.size());
        aSet.add(5);
        assertEquals(5, aSet.size());
        aSet.add(6);
        assertEquals(6, aSet.size());
        aSet.add(7);
        assertEquals(7, aSet.size());
        aSet.add(8);
        assertEquals(8, aSet.size());
        aSet.remove(1);
        assertEquals(7, aSet.size());
        aSet.remove(2);
        assertEquals(6, aSet.size());
        aSet.remove(3);
        assertEquals(5, aSet.size());
        aSet.remove(4);
        assertEquals(4, aSet.size());
        aSet.remove(5);
        assertEquals(3, aSet.size());
        aSet.remove(6);
        assertEquals(2, aSet.size());
        aSet.remove(7);
        assertEquals(1, aSet.size());
        aSet.remove(8);
        assertEquals(0, aSet.size());
    }

    @Test
    public void testtoIntArray(){
        ListSet aSet = new ListSet();
        aSet.add(1);
        aSet.add(2);
        aSet.add(3);
        aSet.add(4);
        aSet.add(5);
        aSet.add(6);
        aSet.add(7);
        aSet.add(8);
        int[] array = aSet.toIntArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
        assertEquals(6, array[5]);
        assertEquals(7, array[6]);
        assertEquals(8, array[7]);
    }
}
