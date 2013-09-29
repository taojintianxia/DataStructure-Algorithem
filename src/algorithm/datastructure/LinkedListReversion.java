package algorithm.datastructure;

/**
 * 
 * @author Kane.Sun
 */
public class LinkedListReversion {

	public static void main(String... args) {

		LinkedListReversion testLink = new LinkedListReversion();
		testLink.push("1");
		testLink.push("2");
		testLink.push("3");
		testLink.push("4");
		revertLinkedList(testLink);
	}

	public static void revertLinkedList(LinkedListReversion linkedList) {
		LinkedListReversion newPointer = new LinkedListReversion();
		while (!linkedList.isEmpty()) {
			newPointer.push(linkedList.pop());
		}
		System.out.println(newPointer.pop());
	}

	private class Pointer {

		String name = "";
		Pointer next;
	}

	public LinkedListReversion() {
		first = new Pointer();
	}

	private Pointer first = new Pointer();

	public boolean isEmpty() {

		return first.next == null;
	}

	public String pop() {

		String s = new String();

		if (!isEmpty()) {
			s = first.name;
			first = first.next;
		} else {
			// throw Exception
			System.out.println("System is throwsing Exception");
		}

		return s;
	}

	public void push(String name) {
		Pointer newPoint = new Pointer();
		newPoint.next = first;
		newPoint.name = name;
		first = newPoint;
	}
}
