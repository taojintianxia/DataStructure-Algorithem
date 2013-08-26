package datastructure;

/**
 * 
 * @author Kane.Sun
 */
public class Node<T> {

	Node next;
	T element;

	public Node() {
	}

	public Node(T element) {
		this.element = element;
	}

	public T getElement() {
		return this.element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
