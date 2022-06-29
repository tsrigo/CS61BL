public class ArrayOperations {
    /**
     * Delete the value at the given position in the argument array, shifting
     * all the subsequent elements down, and storing a 0 as the last element of
     * the array.
     */
    public static void delete(int[] values, int pos) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
        // TODO: YOUR CODE HERE
        while (pos < values.length - 1){
            values[pos] = values[pos + 1];
            pos ++ ;
        }
        values[pos] = 0;
    }

    /**
     * Insert newInt at the given position in the argument array, shifting all
     * the subsequent elements up to make room for it. The last element in the
     * argument array is lost.
     */
    public static void insert(int[] values, int pos, int newInt) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
        // TODO: YOUR CODE HERE
        int tep = pos;
        pos = values.length - 1;
        while (pos > tep){
            values[pos] = values[pos - 1];
            pos -- ;
        }
        values[tep] = newInt;
    }

    /** 
     * Returns a new array consisting of the elements of A followed by the
     *  the elements of B. 
     */
    public static int[] catenate(int[] A, int[] B) {
        // TODO: YOUR CODE HERE
        int[] tep = new int[A.length + B.length];
        int index = 0;
        for (int i : A){
            tep[index ++ ] = i;
        }
        for (int i : B){
            tep[index ++ ] = i;
        }
//        for (int i : tep){
//            System.out.print(i + " ");
//        }
//        System.out.println();
        return tep;
    }

}