package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

    //public static Deque<Integer> ad = new ArrayDeque<Integer>();

    @Test
    public void testaddFirstAndRemoveFirst(){
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        assertEquals(1, ad.size());
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(0, ad.size());
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        assertEquals(3, ad.size());
        assertEquals(3, ad.removeFirst().intValue());
        assertEquals(2, ad.removeFirst().intValue());
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(0, ad.size());
    }   

    @Test
    public void testaddLastAndRemoveLast(){
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addLast(1);
        assertEquals(1, ad.size());
        assertEquals(1, ad.removeLast().intValue());
        assertEquals(0, ad.size());
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertEquals(3, ad.size());
        assertEquals(3, ad.removeLast().intValue());
        assertEquals(2, ad.removeLast().intValue());
        assertEquals(1, ad.removeLast().intValue());
        assertEquals(0, ad.size());
    }
}
