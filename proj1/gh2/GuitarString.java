package gh2;

import deque.ArrayDeque;
import deque.Deque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer = new ArrayDeque<>();

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int ratio = (int) Math.round((double) SR / frequency);
        for (int i = 0; i < ratio; i++) {
            buffer.addFirst((double) 0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        int t = buffer.size();
        while (t > 0) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
            t--;
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double fir = buffer.removeFirst();
        double sec = buffer.get(0);
        buffer.addLast((fir + sec) * DECAY / 2);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
