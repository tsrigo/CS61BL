import java.util.ArrayList;
import java.util.List;

/**
 * Represent a set of ints.
 */
public class ListSet implements SimpleSet {

    List<Integer> elems;

    public ListSet() {
        elems = new ArrayList<Integer>();
    }

    /** Adds k to the set. */
    public void add(int k) {
        // TODO
        boolean flag = false;
        for (int i : elems){
            if (i == k){
                flag = true;
                break;
            }
        }

        if (!flag){
            elems.add(k);
        }
    }

    /** Removes k from the set. */
    public void remove(int k) {
        Integer toRemove = k;
        // TODO - use the above variable with an appropriate List method.
        // The reason is beyond the scope of this lab, but involves
        // method resolution.
        for (Integer i : elems){
            if (i.equals(k)){
                elems.remove(i);
                break;
            }
        }
    }

    /** Return true if k is in this set, false otherwise. */
    public boolean contains(int k) {
        // TODO
        for(int i : elems){
            if (i == k){
                return true;
            }
        }
        return false;
    }

    /** Return true if this set is empty, false otherwise. */
    public boolean isEmpty() {
      return this.size() == 0;
    }

    /** Returns the number of items in the set. */
    public int size() {
        // TODO
        return elems.size();
    }

    /** Returns an array containing all of the elements in this collection. */
    public int[] toIntArray() {
        // TODO - use a for loop!
        int[] ans = new int[size()];
        int index = 0;
        for (int i : elems){
            ans[index ++ ] = i;
        }
        return ans;
    }
}
