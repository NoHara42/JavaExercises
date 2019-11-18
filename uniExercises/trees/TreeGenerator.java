package trees;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class TreeGenerator {

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private double maxWidth;
    private double maxHeight;
    private int depth;

    /**
    * Generates a recursive tree structure.
    * @param a Start point of the trunk
    * @param b End point of the trunk
    * @param c End point of left branch
    * @param d End point of right branch
    */
    public TreeGenerator(Point a, Point b, Point c, Point d,
                         double maxWidth, double maxHeight, int depth) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.depth = depth;
    }

    /**
    * Recursively generates a set of lines representing a tree fractal.
    * This is the initial function that adds the base shape to the list.
    * @return List of lines containing the tree structure
    */
    public List<TreeLine> generateTree() {

        // Adds initial shape
        ArrayList<TreeLine> tree = new ArrayList<TreeLine>();
        tree.add(new TreeLine(a, b));
        tree.add(new TreeLine(b, c));
        tree.add(new TreeLine(b, d));

        // Recursively generates rest of the tree
        tree.addAll(generateTree(a, b, c, d, depth));

        return tree;
    }

    /**
    * Calculates the position of a new branch point
    * @param trunk trunk of the tree
    * @param branchPoint outter point of the branch
    */
    private Point getNewBranchPoint(TreeLine trunk, Point branchPoint, double angle) {

        double scale = new TreeLine(trunk.getB(), branchPoint).lengthFactor(trunk);

        System.out.println("LENGTH FACTOR: "+scale);

        // Vec from trunk to branch
        double x1 = branchPoint.getX() - trunk.getB().getX();
        double y1 = branchPoint.getY() - trunk.getB().getY();

        // Rotates
        double x2 = x1 * Math.cos(angle) - y1 * Math.sin(angle);
        double y2 = x1 * Math.sin(angle) + y1 * Math.cos(angle);

        // Scales
        double x3 = x2 * scale;
        double y3 = y2 * scale;

        // Puts vec at the end of branchPoint
        double x4 = branchPoint.getX() + x3;
        double y4 = branchPoint.getY() + y3;

        System.out.println("Math.cos(angle): "+Math.cos(angle)+" - Angle: "+angle);
        System.out.println("x: " + x4);
        System.out.println("y: " + y4);

        return new Point(x4, y4);
    }

    /**
    * Recursively generates a tree fractal.
    * @param a Start point of the trunk
    * @param b End point of the trunk
    * @param c End point of left branch
    * @param d End point of right branch
    * @return List of lines containing the tree structure
    */
    private List<TreeLine> generateTree(Point a, Point b, Point c, Point d, int depth) {

        ArrayList<TreeLine> tree = new ArrayList<TreeLine>();

        TreeLine trunk = new TreeLine(a, b);
        TreeLine newTrunkLeft = new TreeLine(b, c);
        TreeLine newTrunkRight = new TreeLine(b, d);

        // Calculates new points
        double angleLeft = trunk.angleTo(c);
        double angleRight = trunk.angleTo(d);

        System.out.println("ANGLE LEFT: "+angleLeft);
        System.out.println("ANGLE RIGHT: "+angleRight);

        Point newPointLeftC = getNewBranchPoint(trunk, c, angleLeft);
        Point newPointRightC = getNewBranchPoint(trunk, c, angleRight);
        Point newPointLeftD = getNewBranchPoint(trunk, d, angleLeft);
        Point newPointRightD = getNewBranchPoint(trunk, d, angleRight);

        // Adds new lines
        tree.add(new TreeLine(newTrunkLeft.getB(), newPointLeftC));
        tree.add(new TreeLine(newTrunkLeft.getB(), newPointRightC));
        tree.add(new TreeLine(newTrunkRight.getB(), newPointLeftD));
        tree.add(new TreeLine(newTrunkRight.getB(), newPointRightD));

        // Checks whether the points lie within the canvas
        if (!newPointLeftC.within(maxWidth, maxHeight) ||
            !newPointLeftD.within(maxWidth, maxHeight) ||
            !newPointRightC.within(maxWidth, maxHeight) ||
            !newPointRightD.within(maxWidth, maxHeight)) {
            return tree;
        }

        if (depth <= 0) {
            return tree;
        }

        // Generates left side of the tree
        tree.addAll(
            generateTree(newTrunkLeft.getA(),
                         newTrunkLeft.getB(),
                         newPointLeftC,
                         newPointRightC,
                         depth - 1)
        );

        // Generates right side of the tree
        tree.addAll(
            generateTree(newTrunkLeft.getA(),
                         newTrunkRight.getB(),
                         newPointLeftD,
                         newPointRightD,
                         depth - 1)
        );

        return tree;
    }
    public int getDepth(){
      return this.depth;
    }
}
