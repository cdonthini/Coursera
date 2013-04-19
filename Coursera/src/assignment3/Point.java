/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/
package assignment3;

import java.util.Comparator;

public class Point implements Comparable<Point> {

	private static final double NEGINF = -10000000;

	private static final double POSINF = 10000000;

	// compare points by slope
	public final Comparator<Point> SLOPE_ORDER = new SlopeOrder(); // YOUR DEFINITION HERE

	private class SlopeOrder implements Comparator<Point> {

		public int compare(Point o1, Point o2) {
			double o1Slope = slopeTo(o1);
			double o2Slope = slopeTo(o2);
			if ( o1Slope < o2Slope ) {
				return -1;
			}
			else if ( o1Slope > o2Slope ) {
				return 1;
			}
			return 0;
		}
		
		
	}
	private final int x; // x coordinate
	private final int y; // y coordinate

	// create the point (x, y)
	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	// plot this point to standard drawing
	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	// draw line between this point and that point to standard drawing
	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	// slope between this point and that point
	public double slopeTo(Point that) {
		int denom = that.x - this.x;
		int numer = that.y - this.y;

		if (denom == 0) {

			if (numer == 0) {

				return NEGINF;
			}
			return POSINF;
		} else {
			return numer / denom;
		}

	}

	// is this point lexicographically smaller than that one?
	// comparing y-coordinates and breaking ties by x-coordinates
	public int compareTo(Point that) {
		if ((this.y < that.y) || ((this.y == that.y) && (this.x < that.x))) {
			return -1;
		} else if (this.x == that.x && this.y == that.y) {
			return 0;
		}
		return 1;
		/* YOUR CODE HERE */
	}

	// return string representation of this point
	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

	// unit test
	public static void main(String[] args) {
		/* YOUR CODE HERE */
	}
}