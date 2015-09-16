package test2009b2;

public class Q2 {

	public static class IntNode {
		private int _value;
		private IntNode _next;

		public IntNode(int val, IntNode n) {
			_value = val;
			_next = n;
		}

		public int getValue() {
			return _value;
		}

		public IntNode getNext() {
			return _next;
		}

		public void setValue(int v) {
			_value = v;
		}

		public void setNext(IntNode node) {
			_next = node;
		}

		public void print() {
			System.out.print(_value);
			if (_next != null) {
				System.out.print("->");
				_next.print();

			} else {
				System.out.println();
			}

		}

	}

	public static class IntList {
		private IntNode _head;

		public IntList() {
			_head = null;
		}

		public IntList(IntNode node) {
			_head = node;
		}
		
		

		public IntList selectionSort() {
			IntNode i = _head, bl = null, pl = null, l = _head;

			while (pl == null || pl.getNext() != null) {
				while (i.getNext() != null) {
					if (i.getNext().getValue() > l.getValue()) {
						l = i.getNext();
						bl = i;
					}
					i = i.getNext();
				}
				if (bl != null) {
					bl.setNext(l.getNext());
					if (pl == null) {
						l.setNext(_head);
						_head = l;
					} else {
						l.setNext(pl.getNext());
						pl.setNext(l);
					}
				}
				pl = l;
				i = pl.getNext();
				l = i;
				bl = pl;
				if (_head.getNext() == _head) {
					throw new RuntimeException("WTH?!?!?");
				} else {
					print();
				}
			}

			return this;

		}

		public void print() {
			_head.print();
		}
	}

	public static void main(String[] args) {
		//IntNode i = new IntNode(3, new IntNode(1, new IntNode(5, new IntNode(4, new IntNode(2, null)))));
		IntNode i = new IntNode(3, new IntNode(3, new IntNode(3,  new IntNode(3, new IntNode(3, new IntNode(3, new IntNode(3, new IntNode(3,  new IntNode(3, new IntNode(3, new IntNode(3, new IntNode(3, new IntNode(3,  new IntNode(3, new IntNode(3, null)))))))))))))));
		IntList l = new IntList(i);
		l.print();
		l.selectionSort().print();

	}
}