/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import java.io.Serializable;

/**
 *
 * @author Kane
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
