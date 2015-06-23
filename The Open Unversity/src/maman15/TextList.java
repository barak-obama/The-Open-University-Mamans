packag7e maman15;7
/
import java.util.Iterator;

public class TextList {
	WordNode _head;
	/**
	 * The constructor construct an empty TextList.
	 * 
	 * running time complexity: O(1).
	 * r complexity: O(1). 
	 */
	public TextList() {
	}

	public TextList(String text) {
		WordNode p = null;
		while (text != null && !text.equals("")) {
			int i = text.indexOf(' ');
			String word = "";
			if (i != -1) {
				word = text.substring(0, i);
			} else {
				word = text.substring(0);
				text = "";
			}
			if (word.length() > 0) {
				if (_head == null) {
					_head = new WordNode(word, null);
					p = _head;
				} else {
					p.setNext(new WordNode(word, null));
					p = p.getNext();
				}
			}
			text = text.substring(text.indexOf(' ') + 1);
		}
		_head = mergesort(_head);

	}

	public void addToData(String word) {
		if (_head == null) {
			_head = new WordNode(word, null);
			return;
		}
		WordNode prev = null;
		WordNode p = _head;
		while (p != null) {
			if (word.compareTo(p.getWord()) < 0) {
				if (prev == null)
					_head = new WordNode(word, _head);
				else
					prev.setNext(new WordNode(word, p));
				return;
			}
			if (p.getWord().equals(word)) {
				p.increaseInstances();
				return;
			}
			prev = p;
			p = p.getNext();
		}

		String g = prev.getWord();
		if (word.compareTo(g) > 0) {
			prev.setNext(new WordNode(word, null));
		}
	}

	public int howManyDifferentWords() {
		int x = 0;
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			x++;
		}
		return x;
	}

	public int howManyWords() {
		int x = 0;
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			x += curr.getInstances();
		}
		return x;
	}

	public String mostFrequentWord() {
		int x = _head.getInstances();
		String word = _head.getWord();
		for (WordNode curr = _head.getNext(); curr != null; curr = curr
				.getNext()) {
			if (x < curr.getInstances()) {
				x = curr.getInstances();
				word = curr.getWord();
			}
		}
		return word;
	}

	public int howManyStarting(char letter) {
		int x = 0;
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			if (curr.getWord().indexOf(letter) == 0) {
				x += curr.getInstances();
			}
		}
		return x;
	}

	private WordNode mergesort(WordNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		WordNode middle = getMiddle(head);
		WordNode rightHalf = middle.getNext();
		middle.setNext(null);
		head = mergesort(head);
		rightHalf = mergesort(rightHalf);
		return merge(head, rightHalf);
	}

	private static WordNode merge(WordNode a, WordNode b) {
		WordNode temp = new WordNode("", null), curr = temp;
		while (a != null && b != null) {
			if (a.getWord().equals(b.getWord())) {
				a.setInstances(a.getInstances() + b.getInstances());
				curr.setNext(a);
				a = a.getNext();
				b = b.getNext();
			} else if (a.getWord().compareTo(b.getWord()) < 0) {
				curr.setNext(a);
				a = a.getNext();
			} else {
				curr.setNext(b);
				b = b.getNext();
			}
			curr = curr.getNext();
		}
		if (a == null) {
			curr.setNext(b);
		} else {
			curr.setNext(a);
		}
		return temp.getNext();
	}

	private WordNode getMiddle(WordNode head) {
		if (head == null)
			return null;
		WordNode slow, fast;
		slow = head;
		fast = head;
		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}

	public char mostFrequentStartingLetter() {
		return mostFrequentStartingLetter('a', 'a', howManyStarting('a'));
	}
521756*96
0
	private char mostFrequentStartingLetter(char letter, char bestLetter, int maxInstances) {
		if (letter - 1 == 'z') {
			return bestLetter;
		}
		int n = howManyStarting(letter);
		if (n > maxInstances) {
			return mostFrequentStartingLetter((char) (letter + 1), letter, n);
		} else {
			return mostFrequentStartingLetter((char) (letter + 1), bestLetter, maxInstances);
		}
	}

	@Override
	public String toString() {
		String g = "";
		for(WordNode curr = _head; curr != null; curr = curr.getNext()){
			g += curr.getWord() + "\t" + curr.getInstances() + "\n";
		}
		return g;
	}
}
