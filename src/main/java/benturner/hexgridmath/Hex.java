package benturner.hexgridmath;

/**
 * Data structure representing a single Hex. Its location on the grid is stored using a cube coordinate system.
 * Conversion methods are available to change from cube coordinates to offset (square) coordiantes.
 */

public class Hex {
    private final int q;
    private final int r;
    private final int s;

    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    public int getS() {
        return s;
    }

    /**
     * Constucts a new Hex using the given cube coordinates. The given coordinates must satisfy q+r+s=0.
     * @param q The first cube coordinate
     * @param r The second cube coordinate
     * @param s The third cube coordinate
     * @throws IllegalArgumentException If q+r+s does not equal zero
     */
    public Hex(int q, int r, int s) throws IllegalArgumentException {
        if(q + r + s != 0) {
            throw new IllegalArgumentException("The sum of the three cube coordinates was not zero.");
        }

        this.q = q;
        this.r = r;
        this.s = s;
    }

    /**
     * Constructs a new Hex, using the given q and r coordinates, and auto-calculates the s coordinate (since q+r+s = 0).
     * @param q The first cube coordinate
     * @param r The second cube coordinate
     */
    public Hex(int q, int r) {
        this(q, r, -q-r);
    }

    @Override
    public String toString() {
        return "Hex:[" + this.getQ() + "," + this.getR() + "," + this.getS() + "]";
    }

    /**
     * Two Hex objects are equal iff all their coordinates are equal.
     * @param o An object; if it's a Hex, its coordinates will be evaluated against this Hex's coordinates.
     * @return True iff the given object is a Hex, its coordinates match the coordinates of this Hex.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Hex) {
            Hex other = (Hex) o;
            //since q+r+s = 0, s can always be derived from q and r. Therefore it is sufficient to check only q and r.
            return this.getQ() == other.getQ() && this.getR() == other.getR();
        }
        return false;
    }

    /**
     * Adds the given Hex to this one and returns the result.
     * @param toAdd A Hex
     * @return The Hex that results from adding toAdd to this Hex.
     */
    public Hex addHex(Hex toAdd) {
        return new Hex(this.getQ() + toAdd.getQ(), this.getR() + toAdd.getR(), this.getS() + toAdd.getS());
    }

    /**
     * Subtracts the given Hex from this one and returns the result.
     * @param toSubtract A Hex
     * @return The Hex that results from subtracting toSubtract from this Hex.
     */
    public Hex subtractHex(Hex toSubtract) {
        return new Hex(this.getQ() - toSubtract.getQ(), this.getR() - toSubtract.getR(), this.getS() - toSubtract.getS());
    }

    /**
     * Multiplies the given Hex by a given factor and returns the result.
     * @param factor How much to multiply the Hex's coordinates by
     * @return The Hex that results from multiplying factor with this Hex.
     */
    public Hex hexMultiply(int factor) {
        return new Hex(this.getQ() * factor, this.getR() * factor, this.getS() * factor);
    }
}
