package algorithm.search;

import util.KaneUtil;

/**
 * 
 * @author Kane.Sun
 */
public class FibonacciSearch {

	public static int counter = 20;

	public static void main(String... arg) throws Exception {

		int[] fibonacciArray = KaneUtil.getFibonacciArray(counter);
		int[] sourceArray = KaneUtil.generateRamdomOrderArray(13);

		System.out.print("this is the array we want to search : ");
		for (int i : sourceArray) {
			System.out.print(" " + i);
		}

		int length = sourceArray.length;
		int key = sourceArray[(int) (Math.random() * length - 1)];
		System.out.println("\nhere is the key we want to search : " + key);

		int position = fibonacciSearch(fibonacciArray, sourceArray, key);
		System.out.println("the index of the key is : " + position);
		System.out.println("the corresponding value for index " + position + " is : " + sourceArray[position]);
	}

	@SuppressWarnings("unused")
	public static int fibonacciSearch(int[] fibonacciArray, int[] sourceArray, int key) {

		int length = sourceArray.length;
		int position = 0;
		int i = 1;
		while (length > fibonacciArray[i]) {
			i++;
		}
		int[] tempArray = new int[fibonacciArray[i] + 1];

		System.arraycopy(sourceArray, 0, tempArray, 0, length);
		sourceArray = null;
		sourceArray = tempArray;
		for (int j = length; j <= fibonacciArray[i]; j++) {
			sourceArray[j] = sourceArray[length - 1];
		}

		int high = fibonacciArray[i] - 1;
		int mid = fibonacciArray[i - 1] - 1;
		int low = 0;
		int count = 1;

		while (i != count) {
			count++;
			if (key == sourceArray[mid]) {
				position = mid;
				break;
			} else if (key < sourceArray[mid]) {
				high = mid - 1;
				mid = mid - fibonacciArray[i - count - 1];
				continue;
			} else {
				low = mid + 1;
				mid = mid + fibonacciArray[i - count - 1];
				continue;
			}
		}

		if (position > length) {
			position = length - 1;
		}

		return position;
	}
}
