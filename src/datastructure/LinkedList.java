package datastructure;

import java.io.Serializable;

/**
 * 
 * @author Kane.Sun
 */
public interface LinkedList<T> extends Serializable {

	public Node createLinkedList(int length);

	public void add(T element);

	public void add(int position);

	public void remove(int position);

	public void clear();

	public void contains(T element);

	public int length();

	public boolean isEmpty();
}
