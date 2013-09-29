package algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Kane.Sun
 */
public class BinarySearchArray {

	public static void main(String... args) {

		final int SIZE = 10000;
		// initialize the array
		List<Integer> tempList = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			tempList.add((int) (Math.random() * SIZE));
		}

		Collections.sort(tempList);

		for (int i : tempList) {
			System.out.print(" " + i);
		}
		System.out.println();
		int target = tempList.get((int) (Math.random() * (SIZE - 1)));
		System.out.println("the target is : " + target);

	}

	public static int binarySearch(int[] sourceList, int target) {
		int length = sourceList.length;
		int indexFoward = 0;
		int indexBack = length;
		int counter = 0;
		int targetIndex = -1;
		for (int index = (indexFoward + indexBack) / 2; index < length - 1;) {
			counter++;
			if (sourceList[index] == target) {
				System.out.println("get the target : " + target);
				targetIndex = index;
				break;
			} else if (sourceList[index] < target) {
				indexFoward = index;
				index = (indexFoward + indexBack) / 2;
			} else {
				indexBack = index;
				index = (indexFoward + indexBack) / 2;
			}
		}

		System.out.println("we use " + counter + " times get the target");
		return targetIndex;
	}
}
