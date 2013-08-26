package algorithm.array.sort;

/**
 * 
 * @author Kane.Sun
 */
public class QuickSort {

	public static void main(String... args) {
		int[] testArray = { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };
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