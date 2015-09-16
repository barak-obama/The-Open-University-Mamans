package test2013b3;

public class Q2 {
	public static class CharNode {
		private char _value;
		private CharNode _next;

		public CharNode(char val, CharNode n) {
			_value = val;
			_next = n;
		}

		public CharNode(char val) {
			_value = val;
			_next = null;
		}

		public CharNode getNext() {
			return _next;
		}

		public void setNext(CharNode node) {
			_next = node;
		}

		public char getValue() {
			return _value;
		}

		public void setValue(char v) {
			_value = v;
		}
	}

	public static class CharList {
		private CharNode _head;

		public CharList() {
			_head = null;
		}

		public CharList(String s) {
			_head = new CharNode(s.charAt(0));
			CharNode c = _head;
			for (int i = 1; i < s.length(); i++) {
				c.setNext(new CharNode(s.charAt(i)));
				c = c.getNext();
			}
		}
		
		public String toString() {
			String s = "";
			for (CharNode c = _head; c != null; c = c.getNext()) {
				s += c.getValue();
			}
			return s;
		}

		public int what(char s, char e) {
			int sl = 0, el = 0;

			for (CharNode c = _head; c != null; c = c.getNext()) {
				if(c.getValue() == e) {
					el++;
				}
				
				if(c.getValue() == s) {
					sl++;
				}
			}
			int[] sArr = new int[sl], eArr = new int[el];
			int i = 0, si = 0, ei = 0;
			for (CharNode c = _head; c != null; c = c.getNext()) {
				if(c.getValue() == e) {
					eArr[ei] = i;
					ei++;
				}
				
				if(c.getValue() == s) {
					sArr[si] = i;
					si++;
				}
				i++;
			}
			int count = 0, lastIndex = 0, lastCount = 0;
			
			for (int j = 0; j < eArr.length; j++) {
				
				count += lastCount;
				
				for (int k = lastIndex; k < sArr.length; k++) {
					
					if(eArr[j] > sArr[k]) {
						count++;
						lastCount++;
					} else {
						lastIndex = k;
						break;
					}
					if(k == sArr.length - 1) {
						lastIndex = k + 1;
					}
				}
			}
			return count;
		}
	}
}
