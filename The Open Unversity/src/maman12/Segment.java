package maman12;

public class Segment {
	/**
	 * the left point of the segment
	 */
	private Point1 _poLeft;
	/**
	 * the right point of the segment
	 */
	private Point1 _poRight;

	/**
	 * Construct a segment. If the segment is not parallel to the x axis then
	 * change the y coordinate of the right point according to the y coordinate
	 * of the left point.
	 * 
	 * @param _poLeft
	 *            - The left point of the segment
	 * @param _poRight
	 *            - The right point of the segment
	 */
	public Segment(Point1 _poLeft, Point1 _poRight) {
		if (_poLeft.isUnder(_poRight) || _poLeft.isAbove(_poRight)) {
			_poRight.setY(_poLeft.getX());
		}
		this._poLeft = _poLeft;
		this._poRight = _poRight;
	}

	/**
	 * Construct a segment. If the segment is not parallel to the x axis then
	 * change the y coordinate of the right point according to the y coordinate
	 * of the left point.
	 * 
	 * @param lx
	 *            - The x coordinate of the left point
	 * @param ly
	 *            - The y coordinate of the left point
	 * @param rx
	 *            - The x coordinate of the right point
	 * @param ry
	 *            - The y coordinate of the right point
	 */
	public Segment(int lx, int ly, int rx, int ry) {
		if (ry != ly) {
			ry = ly;
		}
		_poLeft = new Point1(lx, ly);
		_poRight = new Point1(rx, ry);
	}

	/**
	 * Copy constructor for Segments. Construct a segment with the same left and
	 * right points of other segment.
	 * 
	 * @param s
	 *            - The segment object from which to construct the new segment
	 */
	public Segment(Segment s) {
		_poLeft = new Point1(s._poLeft);
		_poRight = new Point1(s._poRight);
	}
	
	/**
	 * Return the left point of the segment.
	 * @return The left point of the segment
	 */
	public Point1 getPoLeft() {
		return _poLeft;
	}
	
	/**
	 * Return the right point of the segment.
	 * @return The right point of the segment
	 */
	public Point1 getPoRight() {
		return _poRight;
	}
	
	/**
	 * Return the segment length.
	 * @return The segment length
	 */
	public int getLength() {
		return (int) _poLeft.distance(_poRight);
	}

	@Override
	/**
	 * Return a string representation of this segment.
	 * @return String representation of this segment
	 */
	public String toString() {
		return _poLeft + "---" + _poRight;
	}
	
	/**
	 * Check if this segment equals other segment.
	 * @param s - The segment to be compared with this segment
	 * @return True if this segment equals other segment
	 */
	public boolean equals(Segment s) {
		return s._poLeft.equals(_poLeft) && s._poRight.equals(_poRight);
	}
	
	/**
	 * Check if this segment is above other segment.
	 * @param s - The segment to check if this segment is above
	 * @return True if this segment is above other segment
	 */
	public boolean isAbove(Segment s) {
		return _poLeft.isAbove(s._poLeft);
	}
	
	/**
	 * Check if this segment is under other segment.
	 * 
	 * @param s - The segment to check if this segment is under
	 * @return True if this segment is under other segment
	 */
	public boolean isUnder(Segment s) {
		return s.isAbove(this);
	}
	
	/**
	 * Check if this segment is to the left of other segment.
	 * @param s - The segment to check if this segment is left of
	 * @return True if this segment is to the left of other segment
	 */
	public boolean isLeft(Segment s) {
		return s._poLeft.isRight(_poRight);
	}
	
	/**
	 * Check if this segment is to the right of other segment.
	 * @param s - The segment to check if this segment is right of
	 * @return True if this segment is to the right of other segment
	 */
	public boolean isRight(Segment s) {
		return s.isLeft(this);
	}
	/**
	 * Move segment by delta in the x direction.
	 * @param d - The amount to move in the x direction
	 */
	public void moveHorizontal(int d) {
		_poLeft.move(d, 0);
		_poRight.move(d, 0);
	}
	/**
	 * Move segment by delta in the y direction.
	 * @param d - The amount to move in the y direction
	 */
	public void moveVertical(int d) {
		_poLeft.move(0, d);
		_poRight.move(0, d);
	}

	/**
	 * Change (increase or decrease) the segment length by delta.
	 * 
	 * @param d
	 *            - The amount by which to increase or decrease the segment
	 *            length
	 */
	public void changeSize(int d) {
		if (getLength() + d >= 0) {
			_poRight.move(d, 0);
		}
	}
	/**
	 * Check if point lies on this segment.
	 * @param p - The point to check if it lies on the segment
	 * @return True if the point lies on this segment
	 */
	public boolean pointOnSegment(Point1 p) {
		return p.getY() == _poLeft.getY() && _poLeft.getX() <= p.getX()
				&& p.getX() <= _poRight.getX();
	}

	/**
	 * Check if this segment is bigger than other segment.
	 * @param s - The segment to check if this segment is bigger than
	 * @return True this segment is bigger than other segment
	 */
	public boolean isBigger(Segment s) {
		return getLength() > s.getLength();
	}
	/**
	 * Calculate the length of the overlap between this and other segments.
	 * @param s - The other segment to calculate the overlap with
	 * @return The length of the overlap between this and other segments
	 */
	public int overlap(Segment s) {
		if (s._poLeft.isLeft(_poRight)) {
			return _poRight.getX() - s._poLeft.getX();
		} else if (s._poRight.isRight(_poLeft)) {
			return s._poRight.getX() - _poLeft.getX();
		}
		return 0;
	}
	/**
	 * Calculate the perimeter of the trapeze formed by this and other segments.
	 * @param s - The other segment
	 * @return The perimeter of the trapeze formed by this and other segments
	 */
	public double trapezePerimeter(Segment s) {
		return getLength() + s.getLength() + s._poLeft.distance(_poLeft)
				+ s._poRight.distance(_poRight);
	}

}
