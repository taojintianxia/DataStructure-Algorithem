package algorithm.array.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * find the loop point of an array , say there is an array , 10 1 2 3 4 5 6 7 8
 * 9 , so , 1 is the loop point
 * 
 * @author Kane.Sun
 * @version Sep 6, 2013 3:13:03 PM
 * 
 */

public class BinarySearchForLoopArray {

	private static Random random = new Random();
	private final static int N = 7;

	public static void main(String... args) {
		List<Integer> tmpList = new ArrayList<>();
		int length = N;
		int start = N;
		while (length == N || start < 2) {
			length = random.nextInt(N) + N;
			start = random.nextInt(length);
		}

		for (int i = start; i < length; i++) {
			tmpList.add(i);
		}

		for (int i = 1; i < start; i++) {
			tmpList.add(i);
		}

		for (int i : tmpList) {
			System.out.print(i + " ");
		}
		System.out.println("the index is : " + binarySearchForLoopInAnArray(tmpList));
	}

	public static int binarySearchForLoopInAnArray(List<Integer> targetList) {
		int length = targetList.size();
		int firstElement = targetList.get(0);
		int indexFoward = 0;
		int indexBack = length - 1;
		int index = indexBack / 2;
		int counter = 0;
		for (int i = 0; i < length - 1; i++) {
			if (index == indexBack || index == indexFoward) {
				break;
			}

			if (firstElement > targetList.get(index)) {
				if (targetList.get(index - 1) > firstElement) {
					break;
				}
				indexBack = index;
				index -= (index - indexFoward) / 2;
			} else {
				if (targetList.get(index + 1) < firstElement) {
					index++;
					break;
				}
				indexFoward = index;
				index += (indexBack - index) / 2;
			}
			counter++;
		}
		System.out.println();
		System.out.println("use " + counter + " times ");

		return index;
	}

}
