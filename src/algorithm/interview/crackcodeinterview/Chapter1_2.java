package algorithm.interview.crackcodeinterview;

import util.KaneUtil;

/**
 * Write code to reverse a C-Style String. (C-String means that ¡°abcd¡± is
 * represented as five characters, including the null character.)
 * 
 * @author Kane.Sun
 * 
 */
public class Chapter1_2 {
	public static void main(String... args) {
		String testStr = KaneUtil.generateRamdomString(10);
		System.out.println(testStr);
		System.out.println(revertStr(testStr));
	}

	public static String revertStr(String str) {
		char[] strArray = str.toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = strArray.length - 1; i > -1; i--) {
			strBuilder.append(strArray[i]);
		}

		return strBuilder.toString();
	}
}
