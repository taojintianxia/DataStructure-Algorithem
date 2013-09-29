package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Kane.Sun
 */
public class KaneUtil {

	private static final int DEFAULT_INT_ARRAY_SCOPE = 100;
	private static Random random = new Random();

	/**
	 * generate a int array with length
	 * 
	 * @param length
	 * @return
	 */
	public static int[] generateRandomIntArray(int length) {

		return generateRandomIntArray(length, length * 5);
	}

	/**
	 * generate a int array with length , and the scope of the element
	 * 
	 * @param length
	 * @param scope
	 * @return
	 */
	public static int[] generateRandomIntArray(int length, int scope) {

		int[] tempIntArray = new int[length];
		int i = 0;
		while (i < length) {
			tempIntArray[i] = random.nextInt(scope);
			i++;
		}

		return tempIntArray;
	}

	/**
	 * generate random String
	 * 
	 * @param length
	 * @return
	 */
	public static String generateRamdomString(int length) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (random.nextBoolean()) {
				strBuilder.append((char) (random.nextInt(26) + 65));
			} else {
				strBuilder.append((char) (random.nextInt(26) + 97));
			}
		}
		return strBuilder.toString();

	}

	public static void printObjectArray(Object[] objArray) {
		for (Object obj : objArray) {
			System.out.println(obj.toString() + " ");
		}
	}

	public static void printIntArray(int[] intArray) {
		for (int i : intArray) {
			System.out.print(i + " ");
		}
	}

	public static int[] getFibonacciArray(int length) {
		int[] fibonacci = new int[length];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for (int i = 2; i < length; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}

		return fibonacci;
	}

	public static int[] generateRamdomOrderArray(int length) {
		int[] tempArray = new int[length];
		tempArray[0] = 1;
		for (int i = 1; i < length; i++) {
			tempArray[i] = tempArray[i - 1] + (int) ((Math.random() + 0.1) * 10);
		}

		return tempArray;
	}

	/**
	 * anagram is two string contains same char but different order , e.g. abcdb
	 * is an angram of abbcd
	 * 
	 * @param str
	 * @return
	 */
	public static String generateAnagrams(String str) {
		int length = str.length();
		char[] charArray = str.toCharArray();
		List<Character> charList = new ArrayList<>();
		StringBuilder strBuilder = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			charList.add(charArray[i]);
		}

		Collections.shuffle(charList);
		for (char chr : charList) {
			strBuilder.append(chr);
		}

		return strBuilder.toString();
	}

	/**
	 * generate a random string contains whitespace
	 * 
	 * @param length
	 * @return
	 */
	public static String generateRandomStrWithWhiteSpace(int length) {
		String str = KaneUtil.generateRamdomString(length);
		StringBuilder strBuilder = new StringBuilder(str);

		for (int i = 0; i < random.nextInt(length - 1) + 1; i++) {
			int index = random.nextInt(length);
			strBuilder.replace(index, index, " ");
		}

		return strBuilder.toString();
	}

	/**
	 * generate the rotation string for original String i.e., "waterbottle" is a
	 * rotation of "erbottlewat"
	 * 
	 * @param orgStr
	 * @return
	 */
	public static String generateRotationString(String orgStr) {
		int index = random.nextInt(orgStr.length() - 2) + 1;
		StringBuilder strBuilder = new StringBuilder(orgStr.substring(index, orgStr.length()));
		strBuilder.append(orgStr.substring(0, index));

		return strBuilder.toString();
	}

	private static void swapString(char[] targetString, int i, int j) {
		char tmpStr = ' ';
		tmpStr = targetString[i];
		targetString[i] = targetString[j];
		targetString[j] = tmpStr;
	}

	public static String shuffleString(String targetString) {
		int length = targetString.length();
		char[] targetStringArray = targetString.toCharArray();
		for (int i = 0; i < length; i++) {
			swapString(targetStringArray, i, random.nextInt(length));
		}

		return new String(targetStringArray);
	}
}
