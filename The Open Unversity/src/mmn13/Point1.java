 package mmn13;

public class Point1 {
	private int _x;
	private int _y;

	public Point1(int x, int y) {
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		_x = x;
		_y = y;
	}

	public Point1(Point1 other) {
		_x = other._x;
		_y = other._y;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public void setX(int x) {
		if (x >= 0) {
			_x = x;
		}
	}

	public void setY(int y) {
		if (y >= 0) {
			_y = y;
		}
	}

	public String toString() {
		return "(" + _x + "," + _y + ")";
	}

	public boolean equals(Point1 other) {
		return (other != null) && (_x == other._x) && (_y == other._y);
	}

	public boolean isAbove(Point1 other) {
		return (other != null) && (_y > other._y);
	}

	public boolean isUnder(Point1 other) {
		return (other != null) && (other.isAbove(this));
	}

	public boolean isLeft(Point1 other) {
		return _x < other._x;
	}

	public boolean isRight(Point1 other) {
		return (other != null) && other.isLeft(this);
	}

	public double distance(Point1 other) {
		return  Math.sqrt(Math.pow(_x - other._x, 2.0D)
				+ Math.pow(_y - other._y, 2.0D));
	}

	public void move(int dx, int dy) {
		int x = _x + dx;
		int y = _y + dy;
		if ((x >= 0) && (y >= 0)) {
			_x = x;
			_y = y;
		}
	}
}
