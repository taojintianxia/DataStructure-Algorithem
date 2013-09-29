package algorithm.interview;

import java.util.Random;

/**
 * say there is a number , if it's even then divide 2 , if it's odd then we
 * could plus 1 or minus 1 , keep on operating , make it as 1. code a method to
 * find most less step. e.g : 7 , we plus 1, then divide 2 , divide 2 , divide
 * 2. totally 4 steps
 * 
 * @author Kane.Sun
 * @version Sep 29, 2013 10:53:24 AM
 * 
 */

public class BestDivideSolution {

	static Random random = new Random();

	public static void main(String... args) {
		int i = random.nextInt(20) + 1;
		decideOperation(i);
	}

	public static void decideOperation(int targetNum) {
		int counter = 0;

		if (targetNum < 1) {
			throw new IllegalArgumentException("wrong parameter , should be more than 0");
		}

		while (targetNum > 0) {
			System.out.println("now number is " + targetNum);
			targetNum = operateForSolution(targetNum);
			counter++;
		}

		counter--;

		System.out.println("it takes " + counter + " times");
	}

	private static int operateForSolution(int num) {
		if (isEven(num)) {
			return num / 2;
		}
		String numStr = binaryToString(num);
		if (numStr.endsWith("01")) {
			return num - 1;
		} else if (numStr.endsWith("011")) {
			return num - 1;
		} else if (numStr.endsWith("111")) {
			return num + 1;
			// now the number is 3
		} else if (numStr.endsWith("11")) {
			return num + 1;
		}

		return -1;
	}

	private static String binaryToString(int num) {
		return Integer.toString(num, 2);
	}

	private static boolean isEven(int num) {
		if (num < 1) {
			throw new IllegalArgumentException("wrong parameter , should be more than 0");
		}
		return num % 2 == 0;
	}

}
