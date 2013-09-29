package algorithm.sort;

/**
 * 
 * @author Kane.Sun
 */
public class InsertionSort {

	public static void main(String... args) {
		int[] testArray = { 3, 6, 9, 2, 7, 1 };
		sort(testArray);
		for (int i : testArray) {
			System.out.print(i + " ");
		}
	}

	public static int[] sort(int[] sourceArray) {
		int[] array = new int[sourceArray.length];
		array[0] = sourceArray[0];
		for (int i = 1; i < sourceArray.length; i++) {
			for (int j = 0; j < i; j++) {
				if (sourceArray[i] > array[j]) {
					continue;
				}
				if (i == sourceArray.length - 1) {
					moveArray(array, j, -1);
				} else {
					moveArray(array, j, i);
				}
				array[j] = sourceArray[i];
			}
		}
		return array;
	}

	public static void moveArray(int[] array, int start, int end) {
		for (int i = end; i >= start; i--) {
			array[i + 1] = array[i];
		}
	}
}
