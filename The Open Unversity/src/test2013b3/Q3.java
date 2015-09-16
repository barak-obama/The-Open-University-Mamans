package test2013b3;

public class Q3 {

	public static class Node {
		private int _number;
		private Node _leftSon, _rightSon;

		public Node(int number) {
			_number = number;
			_leftSon = null;
			_rightSon = null;
		}

		public int getNumber() {
			return _number;
		}

		public Node getLeftSon() {
			return _leftSon;
		}

		public Node getRightSon() {
			return _rightSon;
		}

	}

	public static class BinaryTree {
		public static int f(int a, int b) {
			if (a < b)
				return a;
			return b;
		}

		public static int f(int a, int b, int c) {
			return f(a, f(b, c));
		}

		public static int what(Node t) {
			return what(t, Integer.MAX_VALUE);
		}

		private static int what(Node t, int m) {
			if (t == null)
				return 0;
			if ((t.getLeftSon() == null) && (t.getRightSon() == null))
				return m;
			if (t.getLeftSon() == null)
				return f(m, what(t.getRightSon(), Math.abs(t.getNumber() - t.getRightSon().getNumber())));
			if (t.getRightSon() == null)
				return f(m, what(t.getLeftSon(), Math.abs(t.getNumber() - t.getLeftSon().getNumber())));
			return f(m, what(t.getLeftSon(), Math.abs(t.getNumber() - t.getLeftSon().getNumber())),
					what(t.getRightSon(), Math.abs(t.getNumber() - t.getRightSon().getNumber())));
		}
	}
	
	public static void main(String[] args) {
		Node n25 = new Node(25);
		Node n50 = new Node(50);
		Node n45 = new Node(45);
		
		Node n5 = new Node(5);
		Node n30 = new Node(30);
		
		Node n10 = new Node(10);
		Node n20 = new Node(20);
		
		Node n40 = new Node(40);
		
		n5._leftSon = n50;
		n5._rightSon = n25;
		n30._leftSon = n45;
		
		n20._leftSon = n30;
		n20._rightSon = n5;
		
		n40._leftSon = n20;
		n40._rightSon = n10;
		
		System.out.println(BinaryTree.what(n40));
		
		
	}

}
