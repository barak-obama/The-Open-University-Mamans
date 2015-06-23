package mmn13;

public class Main {
	public static void main(String[] args) {
		Polygon p = new Polygon() {
			{
				addVertex(2, 1);
				addVertex(5, 0);
				addVertex(7, 5);
				addVertex(4, 6);
				addVertex(1, 4);
			}
		};
		Polygon p2 = new Polygon(){
			{
				addVertex(0, 0);
				addVertex(8, 2);
				addVertex(7, 6);
				addVertex(3, 4);
			}
		};
		System.out.println("p.calcArea() = " + p.calcArea());
		System.out.println("p2.calcArea() = " + p2.calcArea());
		System.out.println("p.isBigger(p2) = " + p.isBigger(p2));
		System.out.println("p2.isBigger(p) = " + p2.isBigger(p));
		System.out.println("p.highestVertex() = " + p.highestVertex());
		System.out.println("p2.highestVertex() = " + p2.highestVertex());
		System.out.println("p.calcPerimeter() = " + p.calcPerimeter());
		System.out.println("p2.calcPerimeter() = " + p2.calcPerimeter());
		System.out.println("p.findVertex(new Point1(8,2)) = " + p.findVertex(new Point1(8,2)));
		System.out.println("p2.findVertex(new Point1(8,2)) = " + p2.findVertex(new Point1(8,2)));
		System.out.println("p.findVertex(new Point1(4,6)) = " + p.findVertex(new Point1(4,6)));
		System.out.println("p2.findVertex(new Point1(4,6)) = " + p2.findVertex(new Point1(4,6)));
		
		System.out.println("p.getNextVertex(new Point1(8,2)) = " + p.getNextVertex(new Point1(8,2)));
		System.out.println("p2.getNextVertex(new Point1(8,2)) = " + p2.getNextVertex(new Point1(8,2)));
		System.out.println("p.getNextVertex(new Point1(4,6)) = " + p.getNextVertex(new Point1(4,6)));
		System.out.println("p2.getNextVertex(new Point1(4,6)) = " + p2.getNextVertex(new Point1(4,6)));
		
		System.out.println("p.getBoundingBox() = " + p.getBoundingBox());
		System.out.println("p2.getBoundingBox() = " + p2.getBoundingBox());
		
	}
}
