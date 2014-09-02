package algorithm.interview;

import java.util.Iterator;
import java.util.LinkedList;

public class LastKPointInLinkedList {

	/**
	 * 只遍历单链表一次，而且不分配额外的空间，求倒数第m个节点？ 例如：A－>B->C->D->E->F，求倒数第3个节点，即D。
	 */

	public static void main(String... args) {
		LinkedList<String> testList = new LinkedList<>();
		testList.add("A");
		testList.add("B");
		testList.add("C");
		testList.add("D");
		testList.add("E");
		testList.add("F");

		System.out.println(getLastKNode(testList, 3));
	}

	public static <E> E getLastKNode(LinkedList<E> list, int backPosition) {
		int size = list.size();
		if (backPosition > size) {
			throw new IllegalArgumentException("wrong number");
		}

		E target = null;

		Iterator<E> frontAnchor = list.iterator();
		Iterator<E> endAnchor = list.iterator();

		for (int i = 0; i < backPosition - 1; i++) {
			// it's not a pure linked list
			endAnchor.next();
		}

		while (endAnchor.hasNext()) {
			endAnchor.next();
			target = frontAnchor.next();
		}

		return target;

	}

}
