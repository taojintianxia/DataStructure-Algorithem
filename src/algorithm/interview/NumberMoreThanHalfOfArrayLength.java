package algorithm.interview;

import static util.KaneUtil.generateRamdomString;
import static util.KaneUtil.shuffleString;

import java.util.Random;

/**
 * say there is an array consist with some numbers(or char , whatever), the
 * frequency of occurrence of a number is more than half of the array
 * length.please find this number eg : 11231 , 1 is that number.
 * 
 * @author Kane.Sun
 * @version Sep 22, 2013 9:56:12 AM
 * 
 */

/*
 * for me , there are three solutions :
 * 
 * 1.sort , after sort , in the middle of the array is the number we want
 * 
 * 2.loop the array , put it into a hash map ,the key is number , value is the
 * frequency of occurrence
 * 
 * 3.I believe if we eliminate every "two different number" combination , the
 * left number is what we want
 * 
 * here I'll implement the third thought
 */

public class NumberMoreThanHalfOfArrayLength {

	static Random random = new Random();

	public static void main(String... args) {
		for (int i = 0; i < 50000; i++) {
			String str = generateTestString(10);
			System.out.println(str);
			System.out.println(findTargetChar(str));
		}
	}

	public static String generateTestString(int length) {
		if (length < 3) {
			throw new IllegalArgumentException("length should more than 2");
		}

		StringBuilder strBuilder = new StringBuilder(generateRamdomString(length / 2 - 1));
		int strLength = strBuilder.length();
		char tmpStr = strBuilder.charAt(random.nextInt(strLength));
		for (int i = 0; i < length - strLength; i++) {
			strBuilder.append(tmpStr);
		}

		return shuffleString(strBuilder.toString());
	}

	public static char findTargetChar(String testStr) {
		char targetChar = 0;
		char[] charArray = testStr.toCharArray();
		int length = charArray.length;
		int counter = 1;
		for (int i = 0; i < length; i++) {
			if (i < length - 2) {
				// till current step , there are more than 1 same char left
				if (counter > 1) {
					if (charArray[i] == targetChar) {
						counter++;
						continue;
					} else {
						// skip next char
						i++;
						counter--;
					}
				} else {
					if (charArray[i] == charArray[i + 1]) {
						targetChar = charArray[i];
						counter++;
					} else {
						i++;
					}
				}
			} else {
				if (targetChar != 0) {
					if (targetChar == charArray[length - 1]) {
						counter++;
						break;
					} else {
						counter--;
						break;
					}
				} else {
					targetChar = charArray[length - 1];
				}
			}
		}

		return targetChar;
	}
}
