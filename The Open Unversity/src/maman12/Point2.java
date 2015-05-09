package maman12;



/**
 * This class represents a two-dimensional point on a grid in the first quadrant
 * of the Cartesian coordinate system. The x and y coordinate values must be
 * non-negative (positive or zero) integers.
 * 
 * @author barak
 * @version 1
 */
public class Point2 {
	/**
	 * the distance between the point and the center of the coordinate system.
	 */
	private double _radius;
	
	/**
	 * the angle (in degrees) between the center of the coordinate and point
	 * segment to the X-axis.
	 */
	private double _alpha;

	/**
	 * Construct a point. If one of the parameters is negative then it would be
	 * initialized to zero
	 * 
	 * @param x
	 *            - The x coordinate
	 * @param y
	 *            - The y coordinate
	 */
	public Point2(int x, int y) {
		x = Math.max(x, 0);
		y = Math.max(y, 0);
		this._radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (x != 0)
			this._alpha = 180 * Math.atan((double)y / x) / Math.PI;
		else
			this._alpha = 0;
	}

	/**
	 * Copy constructor for Points. Construct a point with the same coordinates
	 * as other point.
	 * 
	 * @param other
	 *            - The point object from which to construct the new point
	 */
	public Point2(Point2 other) {
		this._radius = other._radius;
		this._alpha = other._alpha;
	}

	/**
	 * Return the x coordinate of the point.
	 * 
	 * @return The x coordinate of the point.
	 */
	public int getX() {
		return (int) Math.round(_radius * Math.cos(Math.PI * _alpha / 180));
	}

	/**
	 * Set the x coordinate of the point. If a negative number is received then
	 * x coordinate does not change.
	 * 
	 * @param x
	 *            - The new x coordinate
	 */
	public void setX(int x) {
		int y = getY();
		if (x >= 0) {
			this._radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			if(x != 0)
				this._alpha = 180 * Math.atan((double)y / x) / Math.PI;
			else {
				this._alpha = 0;
			}
		}
	}

	/**
	 * Return the y coordinate of the point.
	 * 
	 * @return The y coordinate of the point
	 */
	public int getY() {
		return (int) Math.round(_radius * Math.sin(Math.PI * _alpha / 180));
	}

	/**
	 * Set the y coordinate of the point. If a negative number is received then
	 * y coordinate does not change.
	 * 
	 * @param y
	 *            - The new y coordinate
	 */
	public void setY(int y) {
		int x = getX();
		if (y >= 0) {
			this._radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			if(getX()!=0){
				this._alpha = 180 * Math.atan((double)y / x) / Math.PI;
			} else {
				this._alpha = 0;
			}
		}
	}

	@Override
	/**
	 * Return a string representation of this point.
	 * @return String representation of this point
	 */
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

	/**
	 * Check if this point equals other point.
	 * 
	 * @param p
	 *            - The point to be compared with this point
	 * @return True if this point equals other point
	 */
	public boolean equals(Point2 p) {
		return p._radius == _radius && p._alpha == _alpha;
	}

	/**
	 * Check if this point is above other point.
	 * 
	 * @param p
	 *            - The point to check if this point is above
	 * @return True if this point is above other point
	 */
	public boolean isAbove(Point2 p) {
		return getY() > p.getY();
	}

	/**
	 * Check if this point is under other point.
	 * 
	 * @param p
	 *            - The point to check if this point is unde
	 * @return True if this point is under other point
	 */
	public boolean isUnder(Point2 p) {
		return p.isAbove(this);
	}

	/**
	 * Check if this point is to the left of other point.
	 * 
	 * @param p
	 *            - The point to check if this point is left of
	 * @return True if this point is to the left of other point
	 */
	public boolean isLeft(Point2 p) {
		return p.getX() > getX();
	}

	/**
	 * Check if this point is to the right of other point.
	 * 
	 * @param p
	 *            - The point to check if this point is right of
	 * @return True if this point is to the right of other point
	 */
	public boolean isRight(Point2 p) {
		return p.isLeft(this);
	}

	/**
	 * Calculate the distance between this point and other point.
	 * 
	 * @param p
	 *            - The point to calculate distance from
	 * @return The distance between this and other points
	 */
	public double distance(Point2 p) {
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
		int destenationX = getX() + dx, destenationY = getY() + dy;
		Point1 p = new Point1(destenationX, destenationY);
		if (destenationX >= 0 && destenationY >= 0) {
			setX(destenationX);
			setY(destenationY);
		}
	}

}
