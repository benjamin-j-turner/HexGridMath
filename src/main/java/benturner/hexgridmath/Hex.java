package benturner.hexgridmath;

/**
 * Created by bturner on 4/2/2017.
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
}
