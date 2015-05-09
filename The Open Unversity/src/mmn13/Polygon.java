package mmn13;

/**
 * Class Polygon represents a polygon in the first quarter of the 2D space.
 *
 */
public class Polygon {
	/**
	 * The array of the vertices of the polygon.
	 */
	private Point1[] _vertices;
	/**
	 * the numbers of vertices in the polygon.
	 */
	private int _noOfVertices;
	/**
	 * the maximum number of vertices allowed in a polygon.
	 */
	public static final int MAX_NUM_OF_VERTICES = 10;

	/**
	 * The constructor construct empty polygon;
	 */
	public Polygon() {
		_vertices = new Point1[MAX_NUM_OF_VERTICES];
	}

	/**
	 * The function add a new vertex to the polygon. The adding performed only
	 * if there is the number of vertices is under the maximum.
	 * 
	 * @param x
	 *            - the x coordinate of the new vertex.
	 * @param y
	 *            - the y coordinate of the new vertex.
	 * @return true if the function added the vertex successfully and no
	 *         otherwise.
	 */
	public boolean addVertex(int x, int y) {
		return addVertex(new Point1(x, y));
	}

	/**
	 * The function add a new vertex to the polygon. The adding performed only
	 * if there is the number of vertices is under the maximum.
	 * 
	 * @param p
	 *            - the point that will be the new vertex.
	 * @return true if the function added the vertex successfully and no
	 *         otherwise.
	 */
	private boolean addVertex(Point1 p) {
		// check if there is space in the polygon.
		if (_noOfVertices < MAX_NUM_OF_VERTICES)
			return false;

		_vertices[_noOfVertices] = new Point1(p);
		_noOfVertices++;
		return true;
	}

	/**
	 * The function returns a copy of the highest vertex (the point with the
	 * largest t coordinate).
	 * 
	 * @return a copy of the highest vertex (the point with the largest t
	 *         coordinate).
	 */
	public Point1 highestVertx() {
		// it there is no vertices so return null
		if (_noOfVertices == 0)
			return null;

		// search for the highest point
		Point1 highest = _vertices[0];
		for (int i = 1; i < _noOfVertices; i++) {
			if (highest.isUnder(_vertices[i])) {
				highest = _vertices[i];
			}
		}
		return new Point1(highest);
	}

	@Override
	/**
	 * Returns a String representation of the Polygon
	 * 
	 */
	public String toString() {
		String s = "(" + _vertices[0];
		for (int i = 1; i < _noOfVertices; i++) {
			s += "," + _vertices[i];
		}
		s = s + ")";
		if (_noOfVertices != 0)
			return "The polygon has " + _noOfVertices + " vertices:\n" + s;
		return "The polygon has 0 vertices";
	}

	/**
	 * The function calculates and returns the perimeter of the polygon.
	 * 
	 * @return the perimeter of the polygon.
	 */
	public double calcPerimeter() {
		double perimeter = 0;
		// sum the distance between all neighbor vertices.
		for (int i = 0; i < _noOfVertices; i++) {
			// the % operateo is for the case that _vertices[i] is the last
			// vertex is the array
			perimeter += _vertices[i].distance(_vertices[(i + 1)
					% (_noOfVertices)]);
		}
		// if there is only 2 vertices it means that 'perimeter' is twice the
		// distance between the vertices. there for it need to be divided by 2.
		if (_noOfVertices == 2)
			return perimeter / 2;

		return perimeter;
	}

	/**
	 * The function calculates and returns the area of the polygon.
	 * 
	 * @return the area of the polygon.
	 */
	private double calcArea() {
		// if there is less than 3 vertices in the polygon the area is 0.
		if (_noOfVertices < 3) {
			return 0;
		}
		double area = 0;
		// divide the polygon to triangles, calculate their area and sum the
		// areas.
		for (int i = 1; i < _noOfVertices - 1; i++) {
			double a = _vertices[0].distance(_vertices[i]);
			double b = _vertices[0].distance(_vertices[i + 1]);
			double c = _vertices[i].distance(_vertices[i + 1]);
			double s = (a + b + c) / 2;
			area += Math.sqrt(s * (s - a) * (s - b) * (s - c));
		}
		return area;
	}

	/**
	 * The function compare the area of this polygon and the polygon that's
	 * passed as parameter.
	 * 
	 * @param p
	 *            - the polygon to copare the area with.
	 * @return true if the area of this polygon id greater from the area of the
	 *         polygon that's passed as parameter.
	 */
	public boolean isBigger(Polygon p) {
		return calcArea() > p.calcArea();
	}

	/**
	 * finds a given point in the _vertices array, and returns its index in the
	 * array.
	 * 
	 * @param p
	 *            - the point to look for in the array.
	 * @return - the points index in the array. return -1 if point isn't in
	 *         array.
	 */
	public int findVertex(Point1 p) {
		for (int i = 0; i < _noOfVertices; i++) {
			if (_vertices[i].equals(p))
				return i;
		}
		return -1;
	}

	/**
	 * The function returns the vertex that is after the given vertex or null is
	 * case that the given point is'nt in the polygon.
	 * 
	 * @param p
	 *            - the point to find it's next.
	 * @return the vertex that is after the given vertex or null is case that
	 *         the given point is'nt in the polygon.
	 */
	public Point1 getNextVertex(Point1 p) {
		int pos = findVertex(p);
		if (pos == -1)
			return null;
		// the % operateo is for the case that p is the last vertex is the array
		return new Point1(_vertices[(pos + 1) % _noOfVertices]);
	}

	/**
	 * Returns a rectangle that boxes this Polygon.
	 * 
	 * @return - rectangle represented as polygon that boxes this polygon.
	 */
	public Polygon getBoundingBox() {
		// if there is less than 3 vertices in the polygon.
		if (_noOfVertices < 3)
			return null;
		// search for the highest, lowest, most right and most left vertices.
		Point1 highest = _vertices[0];
		Point1 lowest = _vertices[0];
		Point1 rightest = _vertices[0];
		Point1 leftest = _vertices[0];

		for (Point1 p : _vertices) {
			if (highest.isUnder(p))
				highest = p;
			if (lowest.isAbove(p))
				lowest = p;
			if (rightest.isLeft(p))
				rightest = p;
			if (leftest.isRight(p))
				leftest = p;
		}

		// construct the rectangle.
		Polygon box = new Polygon();
		box.addVertex(leftest.getX(), highest.getY());
		box.addVertex(leftest.getX(), lowest.getY());
		box.addVertex(rightest.getX(), lowest.getY());
		box.addVertex(rightest.getX(), rightest.getY());
		return box;

	}

}
