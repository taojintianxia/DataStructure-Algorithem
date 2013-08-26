package algorithm.interview;

import java.util.Random;

/**
 * 
 * @author Kane.Sun
 */
public class GetTopNFromArray {

	public static void main(String... args) {

		int[] intArray = new int[10];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = new Random().nextInt(10);
		}

		for (int j : intArray) {
			System.out.print(j + " ");
		}
		System.out.println();

		int[] targetArray = getTopN(intArray, 5);
		for (int j : targetArray) {
			System.out.print(j + " ");
		}

	}

	public static int[] getTopN(int[] intArray, int n) {

		int[] targetArray = new int[n];
		int j = 0;
		while (j < targetArray.length) {
			targetArray[j] = Integer.MAX_VALUE;
			j++;
		}

		for (int i = 0; i < intArray.length; i++) {
			if (targetArray[targetArray.length - 1] > intArray[i]) {
				insertIntIntoArray(targetArray, intArray[i]);
			}
		}

		return targetArray;
	}

	private static void insertIntIntoArray(int[] targetArray, int number) {

		int i = targetArray.length - 1;
		while (i > 0 && targetArray[i - 1] > number) {
			targetArray[i] = targetArray[i - 1];
			i--;
		}
		targetArray[i] = number;
	}
}