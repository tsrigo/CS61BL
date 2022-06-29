/**
 * A class that represents a measurement in feet and inches. The measurement
 * should be _well-formed_, that is, the number of inches should not be >= 12.
 */
public class Measurement {
    private int foot, inch;
    /**
     * Constructor: initialize this object to be a measurement of 0 feet, 0
     * inches
     */
    public Measurement() {
        foot = 0;
        inch = 0;
    }

    /**
     * Constructor: takes a number of feet as its single argument, using 0 as
     * the number of inches
     */
    public Measurement(int feet) {
        foot = feet;
        inch = 0;
    }

    /**
     * Constructor: takes the number of feet in the measurement and the number
     * of inches as arguments (in that order), and does the appropriate
     * initialization
     */
    public Measurement(int feet, int inches) {
        int tep = feet * 12 + inches;
        foot = tep / 12;
        inch = tep % 12;
    }

    /**
     * Returns the number of feet in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 1.
     */
    public int getFeet() {
        return this.foot; // provided to allow the file to compile
    }

    /**
     * Returns the number of inches in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 6.
     */
    public int getInches() {
        return this.inch; // provided to allow the file to compile
    }

    /**
     * Adds the argument m2 to the current measurement.
     *
     * @param m2 - Measurement to add. Should not change.
     * @return a new Measurement containing the sum of this and m2.
     */
    public Measurement plus(Measurement m2) {
        Measurement ans = new Measurement(this.foot + m2.foot, this.inch + m2.inch);
        return ans; // provided to allow the file to compile
    }

    /**
     * Subtracts the argument m2 from the current measurement. You may assume
     * that m2 will always be smaller than the current measurement.
     *
     * @param m2 - Measurement to subtract. Should not change.
     * @return a new Measurement containing the difference of this and m2.
     */
    public Measurement minus(Measurement m2) {
        Measurement ans = new Measurement(0);
        int tep1 = this.getFeet() * 12 + this.getInches();
        int tep2 = m2.getFeet() * 12 + m2.getInches();

        ans.foot = (tep1 - tep2) / 12;
        ans.inch = (tep1 - tep2) % 12;
        return ans; // provided to allow the file to compile
    }

    /**
     * Returns a new Measurement that is the current measurement multiplied by
     * n. For example, if this object represents a measurement of 7 inches,
     * this.multiple(3) should return an object that represents 1 foot,
     * 9 inches (which totals to 21 inches).
     *
     * The current measurement should not change.
     *
     * @param multipleAmount
     * @return a new Measurement containing this times multipleAmount
     */
    public Measurement multiple(int multipleAmount) {
        Measurement ans = new Measurement(0);
        int tep1 = this.getFeet() * 12 + this.getInches();
        tep1 *= multipleAmount;

        ans.foot = tep1 / 12;
        ans.inch = tep1 % 12;
        return ans; // provided to allow the file to compile
    }

    /**
     * Returns the String representation of this object in the form:
     *      f'i"
     * In other words, th number of feet followed by a single quote followed
     * by the number of inches less than 12 followed by a double quote (with no
     * blanks).
     *
     * For example, 0 foot 2 inches is formatted as 0'2"
     */
    @Override
    public String toString() {
        Measurement tep = this.multiple(1);
        return tep.foot + "\'" + tep.inch + "\"";
    }

}