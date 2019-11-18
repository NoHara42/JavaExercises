package trees;

import java.lang.Math;

public class TreeLine {

    private Point a;
    private Point b;

    /**
    * Line consisting of two coordinates
    */
    public TreeLine(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    /**
    * @return first point of the line
    */
    public Point getA() {
        return a;
    }
    /**
    * @return second point of the line
    */
    public Point getB() {
        return b;
    }

    /**
    * @param other Point to get angle to
    * @return angle
    */
    public double angleTo(Point c) {
        Point vec1 = new Point(b.getX() - a.getX(), b.getY() - a.getY());
        Point vec2 = new Point(c.getX() - b.getX(), c.getY() - b.getY());
        double rad = Math.atan2(vec2.getY(), vec2.getX()) - Math.atan2(vec1.getY(), vec1.getX());

        return rad;
    }

    /**
    * @param other Line to compare to
    * @return length factor compared to other line
    */
    public double lengthFactor(TreeLine other) {
        return this.getLength() / other.getLength();
    }

    /**
    * Euklidean length of the line
    * @return lenght of the line
    */
    public double getLength() {
        return Math.abs(a.distanceTo(b));
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}
