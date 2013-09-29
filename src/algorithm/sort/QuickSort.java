package algorithm.sort;

import util.KaneUtil;

/**
 * 
 * @author Kane.Sun
 */
public class QuickSort {

	public static void main(String... args) {
		int[] testArray = KaneUtil.generateRandomIntArray(10);
		for (int i : testArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		sort(testArray);
		for (int i : testArray) {
			System.out.print(i + " ");
		}
	}

	public static void sort(int[] array) {

		quickSort(array, 0, array.length - 1);

	}

	private static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int index = arrayAjust(array, start, end);
			quickSort(array, start, index - 1);
			quickSort(array, index + 1, end);
		}
	}

	private static int arrayAjust(int[] array, int start, int end) {
		int key = array[start];
		int i = start, j = end;

		while (i < j) {
			while (i < j && array[j] > key) {
				j--;
			}
			if (i < j) {
				array[i] = array[j];
			}

			while (i < j && array[i] < key) {
				i++;
			}
			if (i < j) {
				array[j] = array[i];
			}
		}

		array[i] = key;
		return i;
	}
}