import jh61b.junit.In;

import static java.lang.Math.min;
import static java.lang.Math.pow;

/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    // use recursion to get the size of an Intlist
    public int size(){
        if(this.next == null) return 1;
        else return this.next.size() + 1;
    }
    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        //TODO: YOUR CODE HERE
        if (position < 0){
            throw new IllegalArgumentException("IllegalArgumentException for negative indices");
        }

        IntList i = this;
        int j = 0;
        for (j = 0; i.next != null && j < position; i = i.next, j ++ ){
        }

        if (j < position){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        else{
            return i.item;
        }

    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        //TODO: YOUR CODE HERE
        IntList i = this;
        String str = "";
        for (; i != null; i = i.next){
            str += Integer.toString(i.item);
            if (i.next != null) str += " ";
        }
        return str;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parenthesis. An example of this is on line 84.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntList)) {
            return false;
        }
        IntList otherLst = (IntList) obj;

        // Warning: Here we can't use `str1 == str2` to identify whether str1 and str2 are the same or not.
        // I assume the reason maybe is that they are both objects and i may not be that simple
        String str1 = this.toString(), str2 = otherLst.toString();
        if (str1.equals(str2)) {
//            System.out.println(str1 + " " + str2);
            return true;
        }
        else return false;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        //TODO: YOUR CODE HERE
        IntList i = this;
        while(i.next != null) i = i.next;
        i.next = new IntList(value);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        //TODO: YOUR CODE HERE
        IntList i = this;
        int ans = 0x3f3f3f3f;
        while(i != null) {
            ans = Math.min(ans, i.item);
            i = i.next;
        }
        return ans;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        //TODO: YOUR CODE HERE
        IntList i = this;
        int ans = 0;
        while (i != null){
            ans += i.item * i.item;
            i = i.next;
        }
        return ans;
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
        //TODO: YOUR CODE HERE
        IntList i = A, j = B;
        while (i.next != null) i = i.next;
        i.next = new IntList(j.item, j.next);
        return A;
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
     public static IntList catenate(IntList A, IntList B) {
        //TODO: YOUR CODE HERE
        IntList Copy_A = IntListCopy(A);
        IntList Copy_B = IntListCopy(B);
        IntList ans = Copy_A;
        while (Copy_A.next != null) Copy_A = Copy_A.next;
        Copy_A.next = Copy_B;
        return ans;
     }

     public static IntList IntListCopy(IntList L){
         if (L == null) return null;
         return new IntList(L.item, IntListCopy(L.next));
     }
}