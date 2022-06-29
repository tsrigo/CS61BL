public class ModNCounter {

    private int myCount;
    private int myN;

    public ModNCounter(int x) {
        myCount = 0;
        myN = x;
    }

    public void increment() {
        myCount = (myCount + 1) % myN;
    }

    public void reset() {
        myCount = 0;
    }

    public int value() {
        return myCount;
    }

    public int getMyN(){
        return this.myN;
    }
}
