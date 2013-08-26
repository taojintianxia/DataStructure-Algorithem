package algorithm.interview.crackcodeinterview;

import java.util.Random;

import util.KaneUtil;

/**
 * Write a method to replace all spaces in a string with ¡®%20¡¯.
 * 
 * @author Kane.Sun
 * 
 */

public class Chapter1_5 {

	static Random random = new Random();
	final static String ESCAPE_CHAR = "%20";
	final static String WHITE_SPACE = " ";

	public static void main(String... args) {
		String str = KaneUtil.generateRandomStrWithWhiteSpace(10);
		System.out.println(str);
		System.out.println(replaceWhiteSpace(str));
	}

	private static String replaceWhiteSpace(String targetStr) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < targetStr.length(); i++) {
			if (String.valueOf(targetStr.charAt(i)).equals(WHITE_SPACE)) {
				strBuilder.append(ESCAPE_CHAR);
			} else {
				strBuilder.append(String.valueOf(targetStr.charAt(i)));
			}
		}

		return strBuilder.toString();
	}
}
