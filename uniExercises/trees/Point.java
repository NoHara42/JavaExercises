package trees;

import java.lang.Math;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        System.out.println(this);
    }

    /**
    * @return coordinate
    */
    public double getX() {
        return x;
    }

    /**
    * @return coordinate
    */
    public double getY() {
        return y;
    }

    public double dot(Point other) {
        return (x * other.getX()) + (y * other.getY());
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
    * Checks whether the point lies within specified boundaries (0–w, 0–h)
    * @param w width
    * @param h height
    * @return whether the point's coordinates lie within boundaries
    */
    public boolean within(double w, double h) {
        if (x >= 0 && x <= w && y >= 0 && y <= h) {
            return true;
        } else {
            return false;
        }
    }



    /**
    * Euklidean distance to another point
    * @return distance to other point
    */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
