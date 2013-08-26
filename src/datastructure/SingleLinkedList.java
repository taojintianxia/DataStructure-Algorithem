/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;


/**
 *
 * @author Kane.Sun
 */
public class SingleLinkedList<T> implements LinkedList {

    private Node headNode;
    private Node tailNode;

    public SingleLinkedList() {
        headNode = new Node();
        tailNode = headNode;
    }

    @Override
    public Node createLinkedList(int length) {
        int i = 0;
        while (length > 0 && i < length) {
            tailNode.setNext(new Node());
            tailNode = tailNode.getNext();
            i++;
        }

        return headNode;
    }

    @Override
    public void add(Object element) {
        Node node = new Node();
        tailNode.setNext(node);
        tailNode = node;
    }

    @Override
    public void add(int position) {
        for (int i = 0; i < position; i++) {
        }
    }

    @Override
    public void remove(int position) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void contains(Object element) {

    }

    @Override
    public int length() {
        Node tempNode = headNode;
        int length = 0;
        while (tempNode.hasNext()) {
            tempNode = tempNode.getNext();
            length++;
        }

        return length;
    }

    @Override
    public boolean isEmpty() {
        return headNode.hasNext();
    }

    public static void main(String... args) {
        SingleLinkedList testLink = new SingleLinkedList();
        Node tempNode = testLink.createLinkedList(10);
        testLink.add("test");

        System.out.println(testLink.length());
    }
}
