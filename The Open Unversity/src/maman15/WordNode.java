package maman15;

public class WordNode {
	private String _word;
	private WordNode _next;
	private int _instances;

	public WordNode(String word, WordNode next) {
		_word = word;
		_next = next;
		_instances = 1;
	}

	public WordNode getNext() {
		return _next;
	}

	public void setNext(WordNode _next) {
		this._next = _next;
	}

	public String getWord() {
		return _word;
	}
	
	public void increaseInstances(){
		_instances++;
	}
	
	

	public int getInstances() {
		return _instances;
	}

	public void setInstances(int _instances) {
		this._instances = _instances;
	}
	
	

}
