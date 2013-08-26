package algorithm.interview.crackcodeinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import util.KaneUtil;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * 
 * @author Kane.Sun
 * 
 */
public class Chapter1_1 {

	public static void main(String... args) {
		String testStr = KaneUtil.generateRamdomString(10);
		System.out.println(testStr);
		System.out.println(checkDuplicateCharWithoutExtStructure(testStr));
	}

	public static boolean checkDuplicateChar(String testStr) {
		Map<Character, Boolean> charMap = new HashMap<>();
		int length = testStr.length();
		boolean result = false;
		for (int i = 0; i < length; i++) {
			char tmpChar = testStr.charAt(i);
			if (null != charMap.get(tmpChar) && charMap.get(tmpChar)) {
				result = true;
				break;
			}
			charMap.put(tmpChar, true);
		}

		return result;
	}

	public static boolean checkDuplicateCharWithoutExtStructure(String testStr) {
		boolean result = false;
		String[] tempChar = testStr.split("");
		Arrays.sort(tempChar);
		for (int i = 1; i < testStr.length() - 1; i++) {
			if (tempChar[i].equals(tempChar[i + 1])) {
				result = true;
				break;
			}
	
		}
		return result;
	}
}
