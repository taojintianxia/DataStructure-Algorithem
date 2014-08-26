package algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/*
 * See the picture MountainClimber
 * 
 */

public class MountainClimber {

	public static void main(String... args) {
		MountainClimber climber = new MountainClimber();
		int size = 3;
		String str1 = "1,3,2";
		String str2 = "2,4,4";
		String str3 = "6,7,5";
		System.out.println(climber.calculateTheDistance(size, str1, str2, str3));
	}

	public int calculateTheDistance(int size, String... lines) {
		List<List<Integer>> groups = new ArrayList<>(size);
		int width = 0;
		int hight = 0;
		for (int i = 0; i < size; i++) {
			String parameter = lines[i];
			String[] str = parameter.split(",");
			List<Integer> tempList = new ArrayList<>();
			int strSize = str.length;
			for (int j = 0; j < strSize; j++) {
				tempList.add(Integer.valueOf(str[j]));
				if (j == (strSize - 2)) {
					if (width < Integer.valueOf(str[j])) {
						width = Integer.valueOf(str[j]);
					}
				}
			}
			groups.add(tempList);
		}

		for (int i = 0; i < size; i++) {
			List<Integer> param = isNextInCombo(i, groups);
			int index = param.get(0);
			i = index;
			hight += param.get(1) * 2;
		}

		return hight + width;

	}

	private List<Integer> isNextInCombo(int index, List<List<Integer>> groups) {
		List<Integer> targetList = groups.get(index);
		int end = targetList.get(targetList.size() - 2);
		int hight = targetList.get(targetList.size() - 1);
		int size = groups.size() - 1;
		int currentIndex = index;

		for (int i = index + 1; i < size; i++) {
			List<Integer> tmpList = groups.get(i);
			if (tmpList.get(0) < end) {
				end = tmpList.get(1);
				if (hight < tmpList.get(2)) {
					hight = tmpList.get(2);
				}
				currentIndex = i;
				continue;
			} else {
				hight = tmpList.get(2);
				currentIndex = i;
				break;
			}

		}

		List<Integer> paramList = new ArrayList<>();
		paramList.add(currentIndex);
		paramList.add(hight);
		return paramList;
	}

}
