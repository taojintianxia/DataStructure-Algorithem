package algorithm.interview.crackcodeinterview;

import java.util.Arrays;

import util.KaneUtil;

/**
 * 
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author Kane.Sun
 * 
 */

public class Chapter1_4 {

	public static void main(String... args) {
		String origenalStr = KaneUtil.generateRamdomString(10);
		String targetStr = KaneUtil.generateAnagrams(origenalStr);
		System.out.println(origenalStr);
		System.out.println(targetStr);
		System.out.println(isAnagrams(origenalStr, targetStr));
	}

	public static boolean isAnagrams(String orgigenalStr, String targetStr) {
		boolean result = true;
		int length = orgigenalStr.length();

		if (length != targetStr.length()) {
			result = false;
			return result;
		}

		char[] strChar = orgigenalStr.toCharArray();
		char[] str2Char = targetStr.toCharArray();
		Arrays.sort(strChar);
		Arrays.sort(str2Char);
		for (int i = 0; i < length; i++) {
			if (strChar[i] != str2Char[i]) {
				result = false;
				break;
			}
		}
		return result;
	}

}
