package test2010b3;

public class Q1 {

	public static class CharNode {
		private char _value;
		private CharNode _next;

		public CharNode(char val, CharNode n) {
			_value = val;
			_next = n;
		}

		public char getValue() {
			return _value;
		}

		public CharNode getNext() {
			return _next;
		}

		public void setValue(char v) {
			_value = v;
		}

		public void setNext(CharNode node) {
			_next = node;
		}
		

		public void print() {
			System.out.print(_value);
			if(_next != null) {
				System.out.print('-');
				System.out.print('>');
				_next.print();
			} else {
				System.out.println();
			}
			

		}
	}

	public static class CharList {
		private CharNode _head;

		public CharList() {
			_head = null;
		}

		public static boolean isTrans(CharList l1, CharList l2) {
			return isTrans(l1._head, l2._head, false);
		}
		
		public static CharNode getC(String s) {
			if(s.length() == 0) return null;
			return new CharNode(s.charAt(0), getC(s.substring(1)));
		}
		
		public static void main(String[] args) {
			CharNode c1 = CharList.getC("abbcd");
			CharNode c2 = CharList.getC("aaaaaaaaaaabbbbbbbbbbccccccccccdddddddddddd");
			System.out.println(isTrans(c1, c2, false));
			
		}

		private static boolean isTrans(CharNode l1, CharNode l2, boolean deleting) {
			if (l1 == null && l2 ==  null)
				return true;
			if (!deleting) {
				if (l1.getNext() == null && l2.getNext() == null)
					return true;
				if (l1.getValue() != l2.getValue()) {
					return false;
				}
				if (l1.getNext() == null || l1.getNext().getValue() != l1.getValue())
					return isTrans(l1._next, l2, true);
				return isTrans(l1._next, l2._next, deleting);
			} else {
				if (l2 == null && l1 != null) {
					return false;
				}  else if (l2.getNext() != null && l2.getValue() == l2.getNext().getValue()) {
					return isTrans(l1, l2.getNext(), true);
				} else {
					return isTrans(l1, l2.getNext(), false);
				}
			}
		}
	}
}
