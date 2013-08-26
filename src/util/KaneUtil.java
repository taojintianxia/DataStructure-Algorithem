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

	public static int[] generateRandomIntArray(int length) {

		return generateRandomIntArray(length, DEFAULT_INT_ARRAY_SCOPE);
	}

	public static int[] generateRandomIntArray(int length, int scope) {

		int[] tempIntArray = new int[length];
		int i = 0;
		while (i < length) {
			tempIntArray[i] = (int) (Math.random() * scope);
		}

		return tempIntArray;
	}

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

	public static String generateRandomStrWithWhiteSpace(int length) {
		String str = KaneUtil.generateRamdomString(length);
		StringBuilder strBuilder = new StringBuilder(str);

		for (int i = 0; i < random.nextInt(length - 1) + 1; i++) {
			int index = random.nextInt(length);
			strBuilder.replace(index, index, " ");
		}

		return strBuilder.toString();
	}
}
