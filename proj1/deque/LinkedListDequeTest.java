package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static Deque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);

        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
        assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        Deque<Integer> ad = new LinkedListDeque<>();
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

        ad = new LinkedListDeque<>();
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
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        Deque<Integer> ad = new LinkedListDeque<>();
        assertEquals(0, ad.size());
        ad.removeFirst();
        assertEquals(0, ad.size());
        ad.removeLast();
        assertEquals(0, ad.size());
    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {
        Deque<String> ad = new LinkedListDeque<>();
        ad.addFirst("a");
        ad.addFirst("b");
        ad.addFirst("c");
        assertEquals(3, ad.size());
        assertEquals("c", ad.removeFirst());
        assertEquals("b", ad.removeFirst());
        assertEquals("a", ad.removeFirst());
        assertEquals(0, ad.size());
        assertEquals(null, ad.removeFirst());
        assertEquals(null, ad.removeLast());
    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        Deque<Integer> ad = new LinkedListDeque<>();
        assertEquals(0, ad.size());
        assertEquals(null, ad.removeFirst());
        assertEquals(null, ad.removeLast());
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void testprintDeque(){
        Deque<Integer> ad = new LinkedListDeque<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.printDeque();
    }

    @Test
    public void testaddFirstAndaddLast(){
        Deque<Integer> ad = new LinkedListDeque<>();
        ad.addFirst(1);
        ad.addLast(2);
        assertEquals(2, ad.size());
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(2, ad.removeLast().intValue());
        assertEquals(0, ad.size());
    }

    @Test
    public void testget(){
        Deque<Integer> ad = new LinkedListDeque<>();
        for (int i = 0; i < 50; i ++ ){
            ad.addLast(i);
        }
        ad.printDeque();
        for (int i = 0; i < 50; i ++ ){
            assertEquals(i, ad.get(i).intValue());
            System.out.print(ad.get(i) + " ");
        }
    }

    @Test
    public void testequals(){
        Deque<Integer> ad = new LinkedListDeque<>();
        Deque<Integer> ad2 = new LinkedListDeque<>();
        for (int i = 0; i < 10; i ++ ){
            ad.addLast(i);
            ad2.addLast(i);
        }
        assertTrue(ad.equals(ad2));
        ad.addLast(1);
        assertFalse(ad.equals(ad2));
        ad2.addLast(1);
        assertTrue(ad.equals(ad2));
    }
}
