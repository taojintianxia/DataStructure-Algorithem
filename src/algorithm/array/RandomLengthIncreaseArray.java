package algorithm.array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Sep 10, 2013 4:14:28 PM
 * 
 */

public class RandomLengthIncreaseArray {

	static Random random = new Random();
	private static Map<Integer, String> labelsMap = new LinkedHashMap<>();
	private static final int ARRAY_RANGE = 10;

	public static void main(String... args) {
		printRandomLengthWithAlwaysIncreaseElement(10);
	}

	public static void printRandomLengthWithAlwaysIncreaseElement(int range) {

		int randomTimes = random.nextInt(ARRAY_RANGE - 1) + 1;
		for (int j = 0, i = 0; i < randomTimes; i++) {
			if (randomTimes == ARRAY_RANGE - 1) {
				labelsMap.put(i, random.nextInt() + "");
				System.out.print(i + " ");
				continue;
			}
			int randomIncrease = random.nextInt(ARRAY_RANGE - randomTimes - (j - i));
			if (randomIncrease == 0 && i != 0) {
				++j;
			} else {
				j += randomIncrease;
			}
			labelsMap.put(j, random.nextInt() + "");
			System.out.print(j + " ");
		}

	}
}
