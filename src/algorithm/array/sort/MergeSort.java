package algorithm.array.sort;

/**
 * 
 * @author Kane.Sun
 */
public class MergeSort {

	public static void main(String... args) {
		int[] testArray = { 3, 6, 9, 2, 7, 1, 8, 5, 4 };
		sort(testArray);
		for (int i : testArray) {
			System.out.print(i + " ");
		}
	}

	public static void sort(int[] array) {
		sortArray(array, 0, array.length - 1);
	}

	private static void sortArray(int[] array, int left, int right) {
		if (left == right) {
			return;
		}
		int middle = (left + right) / 2;
		sortArray(array, left, middle);
		sortArray(array, middle + 1, right);
		mergeArray(array, left, middle, right);
	}

	private static void mergeArray(int[] array, int left, int middle, int right) {
		int[] tempArray = new int[array.length];
		int j = middle + 1;
		int k = left;
		int temp = left;

		while (left <= middle && j <= right) {
			if (array[left] <= array[j]) {
				tempArray[k] = array[left];
				left++;
				k++;
			} else {
				tempArray[k] = array[j];
				j++;
				k++;
			}
		}

		while (j <= right) {
			tempArray[k] = array[j];
			j++;
			k++;
		}

		while (left <= middle) {
			tempArray[k] = array[left];
			left++;
			k++;
		}

		while (temp <= right) {
			array[temp] = tempArray[temp++];
		}
	}

}
