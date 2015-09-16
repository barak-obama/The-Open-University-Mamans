package maman15;



/**
 * A data structure used to save information about words from a given text.
 * 
 *
 *
 */
public class TextList {
	WordNode _head;

	/**
	 * The constructor construct an empty TextList.
	 * 
	 * running time complexity: O(1). space complexity: O(1).
	 */
	public TextList() {
	}

	/**
	 * The constructor construct a TextList ( that represent a text, and sort
	 * the word of the text lexicographically (using mergesort algorithm).
	 * 
	 * running time complexity: O(nlogn). space complexity: O(n).
	 * 
	 * @param text
	 *            - the text to build the
	 */
	public TextList(String text) {
		WordNode p = null;
		// iterate over all the words (a.k.a till 'text' is empty String), only
		// if
		while (!text.equals("")) {
			// detect where the first word ends (if there is a space in the
			// beginning, this iteration won't add any word to the list)
			int i = text.indexOf(' ');
			String word = "";
			// if there is a space in 'text' get the substring till the first
			// one.
			if (i != -1) {
				word = text.substring(0, i);
				// else, the whole string is the word
			} else {
				word = text;
				text = "";
			}
			// is 'word' is not "", add it
			if (word.length() > 0) {
				if (_head == null) {
					_head = new WordNode(word, null);
					p = _head;
				} else {
					p.setNext(new WordNode(word, null));
					p = p.getNext();
				}
			}
			// delete the word that was just added (or the space in the
			// beginning of 'text', is there is one).
			text = text.substring(text.indexOf(' ') + 1);
		}
		// sort the list
		_head = mergesort(_head);

	}

	/**
	 * The function adds new word to the list and puts it in the right place.
	 * 
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @param word
	 */
	public void addToData(String word) {
		// if the list is empty, add the word to the first node.
		if (_head == null) {
			_head = new WordNode(word, null);
			return;
		}
		// clear all ' ' from 'word.
		while (word.indexOf(' ') == 0) {
			word = word.substring(1);
		}
		if (word.indexOf(' ') != -1) {
			word = word.substring(0, word.indexOf(' '));
		}
		// make sure there is a word to add.
		if (word == "")
			return;
		WordNode prev = null;
		WordNode p = _head;
		// find the place 'word' needs to be.
		while (p != null) {
			// if 'word' need to be before 'p' and after 'prev', add it.
			if (word.compareTo(p.getWord()) < 0) {
				// if 'prev' is 'null', 'p' is the first node so 'wors' need to
				// be first.
				if (prev == null)
					_head = new WordNode(word, _head);
				// else, 'word' need to be between 'prev' and p
				else
					prev.setNext(new WordNode(word, p));
				return;
			}
			// if 'word' is all ready in the list, note it.
			if (p.getWord().equals(word)) {
				p.increaseInstances();
				return;
			}
			prev = p;
			p = p.getNext();
		}

		// if 'word' doesn't need to be in the list, it need to be after it.
		String g = prev.getWord();
		if (word.compareTo(g) > 0) {
			prev.setNext(new WordNode(word, null));
		}
	}

	/**
	 * The function check how many difference words there are in the list.
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @return the number of difference words in the list
	 */
	public int howManyDifferentWords() {
		int x = 0;
		// Iterate over the list
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			// each node represent a word in the text (there is no equal nodes)
			// so it 'gives' one unique word
			x++;
		}
		return x;
	}

	/**
	 * The function check how many words there are in the list.
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @return the number of words in the list
	 */
	public int howManyWords() {
		int x = 0;
		// Iterate over the list
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			// each node represent a word in the text, so it 'gives' to the
			// count of words the number of it's instances
			x += curr.getInstances();
		}
		return x;
	}

	/**
	 * The function returns the most frequent in the list.
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @return the most frequent in the list.
	 */
	public String mostFrequentWord() {
		// if the list is empty, return ""
		if (_head == null)
			return "";
		int x = _head.getInstances();
		String word = _head.getWord();
		// iterate all the nodes
		for (WordNode curr = _head.getNext(); curr != null; curr = curr
				.getNext()) {
			// if there is more instances of the current node the the most
			// frequent till now' replace the most frequent.
			if (x < curr.getInstances()) {
				x = curr.getInstances();
				word = curr.getWord();
			}
		}
		return word;
	}

	/**
	 * Checks how many words start with the input letter
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @param letter
	 *            - input letter.
	 * @return - number of words that start with the input letter
	 */
	public int howManyStarting(char letter) {
		int x = 0;
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			// if the first character of the current word is equal to the
			// letter,
			// then add all its instances to the counter
			if (curr.getWord().indexOf(letter) == 0) {
				x += curr.getInstances();
			}
		}
		return x;
	}

	/**
	 * Returns the letter that words in the list start with most frequently.
	 * 
	 * @return - letter that words in the list start with most frequently (or
	 *         ' ' if the list is empty)
	 */
	public char mostFrequentStartingLetter() {
		// if the list is empty, return ' '
		if (_head == null)
			return ' ';
		// call the help function
		return mostFrequentStartingLetter('a', 'a', howManyStarting('a'));
	}

	/**
	 * Recursive method that returns the letter that words in the list start
	 * with most frequently.
	 * 
	 * @param letter
	 *            - current char to check
	 * @param bestLetter
	 *            - most frequent char till now
	 * @param maxInstances
	 *            - number of words that start with the char 'ret'
	 * @return - the most frequent starting letter.
	 */
	private char mostFrequentStartingLetter(char letter, char bestLetter,
			int maxInstances) {
		// if we got to the end of the abc, return 'letter'.
		if (letter - 1 == 'z') {
			return bestLetter;
		}
		// check how many words return with 'letter'
		int n = howManyStarting(letter);
		// if 'letter' is the most frequent letter till now, check if there is
		// more frequent letter then 'letter'
		if (n > maxInstances) {
			return mostFrequentStartingLetter((char) (letter + 1), letter, n);
			// else, check if there is more frequent letter ther 'bestLetter'
		} else {
			return mostFrequentStartingLetter((char) (letter + 1), bestLetter,
					maxInstances);
		}
	}

	@Override
	/**
	 * Returns a String representation of the list, each word appears on a
	 * separate line in an alphabetical order, and to the right of it, the
	 * number of instances of it in the text.
	 * 
	 * running time complexity: O(n). space complexity: O(n).
	 * 
	 */
	public String toString() {
		String g = "";
		for (WordNode curr = _head; curr != null; curr = curr.getNext()) {
			g += curr.getWord() + "\t" + curr.getInstances() + "\n";
		}
		return g;
	}

	/**
	 * The function sorts the input list using the mergesort algorithm running
	 * time complexity: O(nlogn). space complexity: O(1).
	 * 
	 * @param head
	 *            - A list of words to sort using the mergesort algorithm
	 * @return - a new sorted list containing the same elements
	 */
	private WordNode mergesort(WordNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		// find middle node
		WordNode middle = getMiddle(head);
		// start of right half
		WordNode rightHalf = middle.getNext();
		// split the two lists
		middle.setNext(null);
		// recursively sort the tow sides
		head = mergesort(head);
		rightHalf = mergesort(rightHalf);

		// return the merge of the two sides
		return merge(head, rightHalf);
	}

	/**
	 * This function merges two sorted lists to one ordered list. Running-time
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @param a
	 *            - first sorted list
	 * @param b
	 *            - second sorted list
	 * @return - a merged sorted list
	 */
	private static WordNode merge(WordNode a, WordNode b) {
		// create a new list
		WordNode temp = new WordNode("", null), curr = temp;
		// as long as two of the lists contain elements, iterate and add it to
		// the new list
		while (a != null && b != null) {
			// if a word is similar to another word, it only adds one of them to
			// the new list, but sums up both of the words' instances
			if (a.getWord().equals(b.getWord())) {
				a.setInstances(a.getInstances() + b.getInstances());
				curr.setNext(a);
				a = a.getNext();
				b = b.getNext();
				// since both lists are sorted, the next largest element will be
				// at the top of the one of the lists
			} else if (a.getWord().compareTo(b.getWord()) < 0) {
				curr.setNext(a);
				a = a.getNext();
			} else {
				curr.setNext(b);
				b = b.getNext();
			}
			curr = curr.getNext();
		}
		// since both lists are sorted, the next largest element will be
		// at the top of the one of the lists
		if (a == null) {
			curr.setNext(b);
		} else {
			curr.setNext(a);
		}
		// returns the next element of 'temp', since the first one is an empty
		// Node just to initialize the list
		return temp.getNext();
	}

	/**
	 * Gets the middle Node from a list using two temporary nodes.
	 * 
	 * running time complexity: O(n). space complexity: O(1).
	 * 
	 * @param head
	 *            - the list to find the middle of.
	 * @return - the middle of the input list.
	 */
	private WordNode getMiddle(WordNode head) {
		if (head == null)
			return null;
		WordNode slow, fast;
		slow = head;
		fast = head;
		// One moves of two at a time, and the other one at a time. the "faster"
		// one moves twice as fast as the slow one, so when the "fast" Node
		// reaches the end, the "slow" Node would reach the middle of the list
		// (with one node difference at maximum).
		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			// move "forward" one
			slow = slow.getNext();
			// move "forward" two
			fast = fast.getNext().getNext();
		}
		return slow;
	}
}
