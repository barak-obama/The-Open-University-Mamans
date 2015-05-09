package maman12;



/**
 * This class represents a two-dimensional point on a grid in the first quadrant
 * of the Cartesian coordinate system. The x and y coordinate values must be
 * non-negative (positive or zero) integers.
 * 
 * @author barak
 * @version 1
 * 
 */
public class Point1 {
	/**
	 * the x coordinate of the point
	 */
	private int _x;
	/**
	 * the y coordinate of the point
	 */
	private int _y;

	/**
	 * Construct a point. If one of the parameters is negative then it would be
	 * initialized to zero
	 * 
	 * @param x
	 *            - The x coordinate
	 * @param y
	 *            - The y coordinate
	 */
	public Point1(int x, int y) {
		this._x = Math.max(x, 0);
		this._y = Math.max(y, 0);
	}

	/**
	 * Copy constructor for Points. Construct a point with the same coordinates
	 * as other point.
	 * 
	 * @param other
	 *            - The point object from which to construct the new point
	 */
	public Point1(Point1 other) {
		this._x = other._x;
		this._y = other._y;
	}

	/**
	 * Return the x coordinate of the point.
	 * 
	 * @return The x coordinate of the point.
	 */
	public int getX() {
		return _x;
	}

	/**
	 * Set the x coordinate of the point. If a negative number is received then
	 * x coordinate does not change.
	 * 
	 * @param x
	 *            - The new x coordinate
	 */
	public void setX(int x) {
		if (x >= 0)
			this._x = x;
	}

	/**
	 * Return the y coordinate of the point.
	 * 
	 * @return The y coordinate of the point
	 */
	public int getY() {
		return _y;
	}

	/**
	 * Set the y coordinate of the point. If a negative number is received then
	 * y coordinate does not change.
	 * 
	 * @param y
	 *            - The new y coordinate
	 */
	public void setY(int y) {
		if (y >= 0)
			this._y = y;
	}

	@Override
	/**
	 * Return a string representation of this point.
	 * @return String representation of this point
	 */
	public String toString() {
		return "(" + _x + "," + _y+")";
	}

	/**
	 * Check if this point equals other point.
	 * 
	 * @param p
	 *            - The point to be compared with this point
	 * @return True if this point equals other point
	 */
	public boolean equals(Point1 p) {
		return p._x == _x && p._y == _y;
	}

	/**
	 * Check if this point is above other point.
	 * 
	 * @param p
	 *            - The point to check if this point is above
	 * @return True if this point is above other point
	 */
	public boolean isAbove(Point1 p) {
		return _y > p._y;
	}

	/**
	 * Check if this point is under other point.
	 * 
	 * @param p
	 *            - The point to check if this point is unde
	 * @return True if this point is under other point
	 */
	public boolean isUnder(Point1 p) {
		return p.isAbove(this);
	}

	/**
	 * Check if this point is to the left of other point.
	 * 
	 * @param p
	 *            - The point to check if this point is left of
	 * @return True if this point is to the left of other point
	 */
	public boolean isLeft(Point1 p) {
		return p._x > _x;
	}

	/**
	 * Check if this point is to the right of other point.
	 * 
	 * @param p
	 *            - The point to check if this point is right of
	 * @return True if this point is to the right of other point
	 */
	public boolean isRight(Point1 p) {
		return p.isLeft(this);
	}

	/**
	 * Calculate the distance between this point and other point.
	 * 
	 * @param p
	 *            - The point to calculate distance from
	 * @return The distance between this and other points
	 */
	public double distance(Point1 p) {
		return Math.sqrt(Math.pow(getX() - p.getX(),2)+Math.pow( getY() - p.getY(),2));
	}

	/**
	 * Move the x coordinate by dX and the y coordinate by dY. If movement moves
	 * the point outside first quadrant, the point will remain at the same place
	 * and not move.
	 * 
	 * @param dx
	 *            - The amount to move in the x direction
	 * @param dy
	 *            - The amount to move in the y direction
	 */
	public void move(int dx, int dy) {
		int destenationX = _x + dx, destenationY = _y + dy;
		if (destenationX >= 0 && destenationY >= 0) {
			_x = destenationX;
			_y = destenationY;
		}
	}

}
