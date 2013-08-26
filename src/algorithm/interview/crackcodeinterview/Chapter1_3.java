package algorithm.interview.crackcodeinterview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import util.KaneUtil;

/**
 * 
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer. NOTE: One or two additional
 * variables are fine. An extra copy of the array is not.
 * 
 * FOLLOW UP
 * 
 * Write the test cases for this method.
 * 
 * @author Kane.Sun
 * 
 */

public class Chapter1_3 {

	public static void main(String... args) {
		String str = "";
		while (!Chapter1_1.checkDuplicateChar(str)) {
			str = KaneUtil.generateRamdomString(10);
		}

		System.out.println(str);
		System.out.println(removeDuplicateStrWithoutExtStructure(str));
	}

	public static String removeDuplicateStr(String str) {
		char[] tmpChar = str.toCharArray();
		Map<Character, String> tmpCharMap = new HashMap<>();
		for (char chr : tmpChar) {
			tmpCharMap.put(chr, "");
		}

		Iterator<Character> it = tmpCharMap.keySet().iterator();
		StringBuilder strBuilder = new StringBuilder();
		while (it.hasNext()) {
			strBuilder.append(it.next());
		}

		return strBuilder.toString();
	}

	public static String removeDuplicateStrWithoutExtStructure(String str) {
		char[] tmpChar = str.toCharArray();
		int length = tmpChar.length;
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (tmpChar[i] == tmpChar[j]) {
					tmpChar[j] = '\0';
				}
			}

			if (tmpChar[i] != '\0') {
				strBuilder.append(tmpChar[i]);
			}
		}

		return strBuilder.toString();
	}
}
