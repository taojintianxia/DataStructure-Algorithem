package algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * We have a 14 cards in hand, every card marks a letter from
 * A,B,C,D,E,F,G,H,I,J,K,L,M,N Your task is to discard cards from them according
 * to some rules, and try to discards all the cards from hand. Rule 1: We MUST
 * discard a pairt of cards with same letter. for example B,B or C,C etc Rule 2:
 * We can discard three adjacent cards. for example, A,B,C or B,C,D or G,H,I etc
 * Please note, once the cards have been discarded, you could not use them
 * again. Then we have a method need you to implement, the input is an array of
 * cards in hand, the output is whether those cards can all be discarded or not.
 * Return 1 means we can discard all cards in hand, otherwise return 0. For
 * example, we have 14 cards in hand like this A,A,B,C,D,D,E,F,G,H,I,L,M,N We
 * can discard all cards from hand like this A,A B,C,D D,E,F G,H,I L,M,N So you
 * need return 1 in your codes.
 * 
 * @author Kane.Sun
 * @version Sep 11, 2013 11:31:24 AM
 * 
 */

public class PlayCards {
	public static void main(String... args) {
		String[] input = new String[] { "A", "A", "B", "C", "D", "D", "E", "F", "G", "H", "I", "L", "M", "N" };
		List<String> targetList = new ArrayList<>();
		targetList.addAll(Arrays.asList(input));
		Collections.sort(targetList);
		System.out.println(isMatch(targetList));
	}

	static int isMatch(List<String> targetList) {
		int length = targetList.size();
		int result = 0;
		for (int i = 0; i < length / 2 + 1; i++) {
			if (targetList.isEmpty()) {
				result = 1;
				break;
			}
			if (!(releaseDuplicateCombination(targetList) || removeMaximumSubArray(targetList)))
				break;
		}
		if (!targetList.isEmpty()) {
			result = 0;
		}
		return result;
	}

	private static boolean removeMaximumSubArray(List<String> targetList) {
		boolean result = false;
		if (targetList.size() < 2) {
			System.out.println("mei xi le");
			return result;
		} else {
			int counter = 1;
			int i = 0;
			while (i < targetList.size() - 1 && targetList.get(i).compareTo(targetList.get(i + 1)) == -1) {
				counter++;
				i++;
			}
			if (counter > 2) {
				for (int x = 0; x < counter; x++) {
					System.out.print(targetList.get(0) + "-");
					targetList.remove(0);
				}
				result = true;
			}
		}
		System.out.println();
		return result;
	}

	private static boolean releaseDuplicateCombination(List<String> targetList) {
		boolean result = false;
		if (targetList.size() < 2) {
			System.out.println("mei xi le");
			return result;
		} else {
			if (targetList.get(0).equals(targetList.get(1))) {
				result = true;
				System.out.print(targetList.get(0) + "-");
				targetList.remove(0);
				System.out.println(targetList.get(0) + "-");
				targetList.remove(0);
			}
		}

		return result;
	}
}
