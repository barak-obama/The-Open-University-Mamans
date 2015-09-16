package maman15;



/**
 * Represents a single node of a linked list of words
 */
public class WordNode {
	/**
	 * The 'info' of the node. (A single word).
	 */
	private String _word;
	/**
	 * A reference to the next Node in the list
	 */
	private WordNode _next;
	/**
	 * The number of instances that the current words have in the whole text
	 * that the linked list represents. Starts as 1 to indicate that the word
	 * appears once in the text.
	 */
	private int _instances;

	/**
	 * Construct the current node with a given word, and the next node in the
	 * list.
	 * 
	 * @param word
	 *            - input word
	 * @param next
	 *            - the next node in the list
	 */
	public WordNode(String word, WordNode next) {
		_word = word;
		_next = next;
		_instances = 1;
	}

	/**
	 * Returns the next node in the list
	 * 
	 * @return - next node in the linked list
	 */
	public WordNode getNext() {
		return _next;
	}

	/**
	 * Sets the next node in the list
	 * 
	 * @param next
	 *            - the next node to set
	 */
	public void setNext(WordNode _next) {
		this._next = _next;
	}

	/**
	 * Returns the word that this node represents in the text
	 * 
	 * @return - word that this node represents in the text
	 */
	public String getWord() {
		return _word;
	}

	/**
	 * Increases the number of instances of the word by 1
	 */
	public void increaseInstances() {
		_instances++;
	}

	/**
	 * Returns the number of instances of the current word
	 * 
	 * @return - number of instances of the current word in the text
	 */
	public int getInstances() {
		return _instances;
	}

	/**
	 * Sets the number of instances to the given parameter
	 * 
	 * @param instances
	 *            - the number to set the instances to.
	 */
	public void setInstances(int _instances) {
		this._instances = _instances;
	}

}
